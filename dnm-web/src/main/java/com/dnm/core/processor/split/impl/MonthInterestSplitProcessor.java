/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.constant.CommonConstant;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AmountUtil;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.CalculateUtil;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.common.util.DateUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.processor.split.BaseSplitProcessor;
import com.dnm.core.processor.split.SplitProcessor;
import com.dnm.core.service.domain.model.bill.InvestDueinRecordModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.facade.constant.PeriodTypeEnum;
import com.dnm.facade.constant.RepayMethodEnum;

/**
 * 按月付息，到期还本处理器
 * 
 * @author hongmin.zhonghm
 * @version $Id: MonthInterestSplitProcessor.java, v 0.1 2014-5-25 下午11:24:01 hongmin.zhonghm Exp $
 */
public class MonthInterestSplitProcessor extends BaseSplitProcessor implements SplitProcessor {

    /** 
     * @see com.dnm.core.processor.split.SplitProcessor#split(com.dnm.core.service.domain.model.bill.InvestRecordModel)
     */
    @Override
    public void split(InvestRecordModel mainRcd) {
        //校验
        check(mainRcd);

        //生成投标明细
        genInvestDueinRecordModel(mainRcd);

        //更新主标相关金额
        updateMainRcdAmount(mainRcd);

        //记账
        account(mainRcd);
    }

    /**
     * 检查合法性
     * 
     * @param mainRcd
     */
    private void check(InvestRecordModel mainRcd) {
        String repayMtd = mainRcd.getRepayMethod();
        String expectMtd = RepayMethodEnum.MONTH_INTEREST.getCode();
        AssertUtil.equals(repayMtd, expectMtd, ResultCodeEnum.BIZ_PARAM_ILLEGAL,
            "repay method is illegal,expect:" + expectMtd + ",actual:" + repayMtd);

        //按月付息，到期还本方式期限必须为月或年
        String periodType = mainRcd.getPeriodType();
        AssertUtil.isTrue(StringUtil.equals(periodType, PeriodTypeEnum.YEAR.getCode())
                          || StringUtil.equals(periodType, PeriodTypeEnum.MONTH.getCode()),
            ResultCodeEnum.BIZ_PARAM_ILLEGAL, "period type must be year or month , actual:"
                                              + periodType);
    }

    /**
     * 获取投标总月数
     * 
     * @param mainRcd
     * @return
     */
    private int getTotalMonths(InvestRecordModel mainRcd) {
        String periodType = mainRcd.getPeriodType();
        int period = mainRcd.getPeriod();

        return StringUtil.equals(periodType, PeriodTypeEnum.YEAR.getCode()) ? period * 12 : period;

    }

    /**
     * 生成投标明细
     * 
     * @param mainRcd
     * @param periodIndex
     * @return
     */
    private void genInvestDueinRecordModel(InvestRecordModel mainRcd) {
        Date now = DnmContextHolder.getTime();
        int totalMonths = getTotalMonths(mainRcd);
        List<InvestDueinRecordModel> investDueinRecordModels = new ArrayList<InvestDueinRecordModel>(
            totalMonths);
        for (int i = 1; i <= totalMonths; i++) {
            BigDecimal interestAmt = CalculateUtil.calcAmt(mainRcd.getInvestAmt(),
                CalculateUtil.calcMonthRate(mainRcd.getInterestRate()), null);
            InvestDueinRecordModel model = new InvestDueinRecordModel();
            model.setId(DBKeyUtil.complete16(now, sequenceService.getDnmInvestDueinRcdSeq()));
            model.setInvestRecordId(mainRcd.getId());
            model.setPeriodIndex(i);
            model.setRepayAmt(interestAmt);
            model.setRepayInterestAmt(interestAmt);
            model.setRepayDate(DateUtil.getBeforeMonthString(mainRcd.getInvestDate(), 0 - i));
            model.setIsDelay(CommonConstant.NO);
            model.setIsFinish(CommonConstant.NO);
            model.setGmtCreate(now);
            model.setGmtModified(now);
            investDueinRecordModels.add(model);
        }

        //最后一月的明细总额需要加上本金
        InvestDueinRecordModel lastRecord = investDueinRecordModels.get(totalMonths - 1);
        lastRecord.setRepayAmt(AmountUtil.add(lastRecord.getRepayAmt(), mainRcd.getInvestAmt()));

        mainRcd.setInvestDueinRecordModels(investDueinRecordModels);
    }

}
