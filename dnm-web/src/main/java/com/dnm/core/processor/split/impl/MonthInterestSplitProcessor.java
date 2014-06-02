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
import com.dnm.core.service.domain.model.bill.InvestPriceCostModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.facade.constant.AccountTransCodeEnum;
import com.dnm.facade.constant.PeriodTypeEnum;
import com.dnm.facade.constant.RepayMethodEnum;
import com.dnm.facade.request.AccountTransferRequest;

/**
 * ���¸�Ϣ�����ڻ���������
 * 
 * @author hongmin.zhonghm
 * @version $Id: MonthInterestSplitProcessor.java, v 0.1 2014-5-25 ����11:24:01 hongmin.zhonghm Exp $
 */
public class MonthInterestSplitProcessor extends BaseSplitProcessor implements SplitProcessor {

    /** 
     * @see com.dnm.core.processor.split.SplitProcessor#split(com.dnm.core.service.domain.model.bill.InvestRecordModel)
     */
    @Override
    public void split(InvestRecordModel mainRcd) {
        //����Ͷ����ϸ
        genInvestDueinRecordModel(mainRcd);

        //����������ؽ��
        updateMainRcdAmount(mainRcd);

        //����
        account(mainRcd);
    }

    /**
     * ���Ϸ���
     * 
     * @param mainRcd
     */
    public void check(InvestRecordModel mainRcd) {
        String repayMtd = mainRcd.getRepayMethod();
        String expectMtd = RepayMethodEnum.MONTH_INTEREST.getCode();
        AssertUtil.equals(repayMtd, expectMtd, ResultCodeEnum.INVEST_ILLEGAL,
            "repay method is illegal,expect:" + expectMtd + ",actual:" + repayMtd);

        //���¸�Ϣ�����ڻ�����ʽ���ޱ���Ϊ�»���
        String periodType = mainRcd.getPeriodType();
        AssertUtil.isTrue(StringUtil.equals(periodType, PeriodTypeEnum.YEAR.getCode())
                          || StringUtil.equals(periodType, PeriodTypeEnum.MONTH.getCode()),
            ResultCodeEnum.INVEST_ILLEGAL, "period type must be year or month , actual:"
                                           + periodType);
    }

    /**
     * ��ȡͶ��������
     * 
     * @param mainRcd
     * @return
     */
    public int getTotalMonths(InvestRecordModel mainRcd) {
        String periodType = mainRcd.getPeriodType();
        int period = mainRcd.getPeriod();

        return StringUtil.equals(periodType, PeriodTypeEnum.YEAR.getCode()) ? period * 12 : period;

    }

    /**
     * ����Ͷ����ϸ
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

        //���һ�µ���ϸ�ܶ���Ҫ���ϱ���
        InvestDueinRecordModel lastRecord = investDueinRecordModels.get(totalMonths - 1);
        lastRecord.setRepayAmt(AmountUtil.add(lastRecord.getRepayAmt(), mainRcd.getInvestAmt()));

        mainRcd.setInvestDueinRecordModels(investDueinRecordModels);
    }

    /**
     * ����������ؽ����������ã���Ϣ��������Ľ��ֻ��Ϊչʾ�ο���ʵ�ʽ��������䶯
     * 
     * @param mainRcd
     */
    private void updateMainRcdAmount(InvestRecordModel mainRcd) {
        //����������б�
        List<InvestPriceCostModel> priceCosts = mainRcd.getNewInvestPriceCostModels();
        BigDecimal priceAmt = new BigDecimal("0");
        BigDecimal costAmt = new BigDecimal("0");
        for (InvestPriceCostModel priceCost : priceCosts) {
            if (StringUtil.equals(priceCost.getTransType(), AccountTransCodeEnum.INCOME.getCode())) {
                priceAmt = AmountUtil.add(priceAmt, priceCost.getTransAmt());
            } else {
                costAmt = AmountUtil.add(costAmt, priceCost.getTransAmt());
            }
        }
        mainRcd.setPriceAmt(priceAmt);
        mainRcd.setCostAmt(costAmt);

        //Ԥ����Ϣ����Ϣ����ѣ�����ÿ����ϸ����ȷ��ʱ�ķ��ʻ�䶯�������û�����ﵽĳһ�߶�ʱ�����������Żݣ���������ֻ�ǲο�
        BigDecimal interestAmt = new BigDecimal("0");
        BigDecimal interestFeeAmt = new BigDecimal("0");
        BigDecimal feeRate = mainRcd.getFeeRate();
        if (AmountUtil.isGreaterThanZero(feeRate)) {
            List<InvestDueinRecordModel> dueinRcds = mainRcd.getInvestDueinRecordModels();
            for (InvestDueinRecordModel dueinRcd : dueinRcds) {
                interestAmt = AmountUtil.add(interestAmt, dueinRcd.getRepayInterestAmt());
                interestFeeAmt = AmountUtil.add(interestFeeAmt,
                    CalculateUtil.calcAmt(dueinRcd.getRepayInterestAmt(), feeRate, null));
            }
        }
        //��Ϣ
        mainRcd.setInterestAmt(interestAmt);
        //��Ϣ�����
        mainRcd.setCostAmt(AmountUtil.add(mainRcd.getCostAmt(), interestFeeAmt));
    }

    /**
     * ����
     * 
     * @param mainRcd
     */
    private void account(InvestRecordModel mainRcd) {
        //����������б�
        List<InvestPriceCostModel> priceCosts = mainRcd.getNewInvestPriceCostModels();
        for (InvestPriceCostModel priceCost : priceCosts) {
            AccountTransferRequest request = new AccountTransferRequest();
            request.setUserId(mainRcd.getPlatformUserModel().getUserId());
            request.setGuid(mainRcd.getId());
            //�����ϵ�bizId��guid��ͬ
            request.setBizId(mainRcd.getId());

        }
    }
}
