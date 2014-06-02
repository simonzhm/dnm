/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.CalculateUtil;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.factory.InvestRecordFactory;
import com.dnm.core.service.domain.model.bill.InvestFromAccountModel;
import com.dnm.core.service.domain.model.bill.InvestPriceCostModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.request.FromAccountRequest;
import com.dnm.facade.request.InvestPriceCostRequest;
import com.dnm.facade.request.InvestRequest;

/**
 * 投标记录领域工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordFactoryImpl.java, v 0.1 2014-5-15 下午1:10:15 hongmin.zhonghm Exp $
 */
public class InvestRecordFactoryImpl extends AbstractDomainService implements InvestRecordFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.InvestRecordFactory#compose(com.dnm.facade.request.InvestRequest)
     */
    @Override
    public InvestRecordModel compose(InvestRequest requestData) {
        InvestRecordModel model = new InvestRecordModel();
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        String id = DBKeyUtil.complete16(date, sequenceService.getDnmInvestRcdSeq());

        model.setId(id);
        model.setPlatformUserId(requestData.getPlatformUserId());
        model.setPeriod(Integer.parseInt(requestData.getPeriod()));
        model.setPeriodType(requestData.getPeriodType());
        model.setRepayMethod(requestData.getRepaymentMethod());
        model.setInvestAmt(new BigDecimal(requestData.getInvestAmt()));
        model.setInvestDate(requestData.getInvestDate());
        //利率的计算统一使用CalculateUtil.calcRateNonPercent
        model.setInterestRate(CalculateUtil.getRateNonPercent(requestData.getInterestRate()));
        model.setInterestRateType(requestData.getInterestRateType());
        model.setFeeRate(CalculateUtil.getRateNonPercent(requestData.getFeeRate()));
        model.setIsFinish(requestData.getIsFinish());

        //网贷平台用户
        PlatformUserModel puModel = new PlatformUserModel();
        puModel.setUserId(requestData.getUserId());
        puModel.setPlatformUserId(requestData.getPlatformUserId());
        model.setPlatformUserModel(puModel);

        List<InvestPriceCostModel> priceCostModelList = new ArrayList<InvestPriceCostModel>();
        //如果奖励列表不为空
        List<InvestPriceCostRequest> priceList = requestData.getInvestPriceList();
        if (!CollectionUtils.isEmpty(priceList)) {
            for (InvestPriceCostRequest price : priceList) {
                priceCostModelList.add(composePriceCostModel(model, price));
            }
        }
        //如果费用列表不为空
        List<InvestPriceCostRequest> costList = requestData.getInvestCostList();
        if (!CollectionUtils.isEmpty(costList)) {
            for (InvestPriceCostRequest cost : costList) {
                priceCostModelList.add(composePriceCostModel(model, cost));
            }
        }
        //奖励与费用的累积金额统一在后面的领域服务里计算
        model.setNewInvestPriceCostModels(priceCostModelList);

        //资金来源账户
        List<InvestFromAccountModel> fromAccountModels = new ArrayList<InvestFromAccountModel>();
        List<FromAccountRequest> fromAcconts = requestData.getFromAccountList();
        for (FromAccountRequest fromAccont : fromAcconts) {
            fromAccountModels.add(composeInvestFromAccountModel(model, fromAccont));
        }
        model.setInvstFromAccountModels(fromAccountModels);

        return model;
    }

    /**
     * 组装投标交易日志模型
     * 
     * @param model
     * @param priceCostRequestData
     * @return
     */
    private InvestPriceCostModel composePriceCostModel(InvestRecordModel model,
                                                       InvestPriceCostRequest priceCostRequestData) {
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        InvestPriceCostModel priceCostModel = new InvestPriceCostModel();
        priceCostModel
            .setId(DBKeyUtil.complete16(date, sequenceService.getDnmInvestPriceCostSeq()));
        priceCostModel.setGuid(model.getId());
        priceCostModel.setBizId(null);
        priceCostModel.setTransType(StringUtil.substring(priceCostRequestData.getType(), 0, 2));
        priceCostModel.setTransSubType(priceCostRequestData.getType());
        priceCostModel.setOrigTransAmt(new BigDecimal(priceCostRequestData.getOrigAmt()));
        priceCostModel.setTransCurrency(CurrencyEnum.CNY.getCode());
        priceCostModel
            .setTransRate(CalculateUtil.getRateNonPercent(priceCostRequestData.getRate()));
        priceCostModel.setTransAmt(CalculateUtil.calcAmt(priceCostRequestData.getOrigAmt(),
            priceCostRequestData.getRate(), priceCostRequestData.getActualAmt()));
        priceCostModel.setGmtCreate(date);
        priceCostModel.setGmtModified(date);

        return priceCostModel;
    }

    /**
     * 组装资金来源模型
     * 
     * @param investRecordModel
     * @param fromAccont
     * @return
     */
    private InvestFromAccountModel composeInvestFromAccountModel(InvestRecordModel investRecordModel,
                                                                 FromAccountRequest fromAccont) {
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        InvestFromAccountModel model = new InvestFromAccountModel();
        model.setInvestRecordId(investRecordModel.getId());
        model.setAccountId(fromAccont.getAccountId());
        model.setAmount(new BigDecimal(fromAccont.getAmount()));
        model.setCurrency(fromAccont.getCurrency());
        model.setGmtCreate(date);
        model.setGmtModified(date);
        return model;
    }
}
