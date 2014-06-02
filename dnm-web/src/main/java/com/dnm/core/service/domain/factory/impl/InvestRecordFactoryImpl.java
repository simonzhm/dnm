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
 * Ͷ���¼���򹤳�
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordFactoryImpl.java, v 0.1 2014-5-15 ����1:10:15 hongmin.zhonghm Exp $
 */
public class InvestRecordFactoryImpl extends AbstractDomainService implements InvestRecordFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.InvestRecordFactory#compose(com.dnm.facade.request.InvestRequest)
     */
    @Override
    public InvestRecordModel compose(InvestRequest requestData) {
        InvestRecordModel model = new InvestRecordModel();
        //����������ȡ������
        Date date = DnmContextHolder.getTime();

        String id = DBKeyUtil.complete16(date, sequenceService.getDnmInvestRcdSeq());

        model.setId(id);
        model.setPlatformUserId(requestData.getPlatformUserId());
        model.setPeriod(Integer.parseInt(requestData.getPeriod()));
        model.setPeriodType(requestData.getPeriodType());
        model.setRepayMethod(requestData.getRepaymentMethod());
        model.setInvestAmt(new BigDecimal(requestData.getInvestAmt()));
        model.setInvestDate(requestData.getInvestDate());
        //���ʵļ���ͳһʹ��CalculateUtil.calcRateNonPercent
        model.setInterestRate(CalculateUtil.getRateNonPercent(requestData.getInterestRate()));
        model.setInterestRateType(requestData.getInterestRateType());
        model.setFeeRate(CalculateUtil.getRateNonPercent(requestData.getFeeRate()));
        model.setIsFinish(requestData.getIsFinish());

        //����ƽ̨�û�
        PlatformUserModel puModel = new PlatformUserModel();
        puModel.setUserId(requestData.getUserId());
        puModel.setPlatformUserId(requestData.getPlatformUserId());
        model.setPlatformUserModel(puModel);

        List<InvestPriceCostModel> priceCostModelList = new ArrayList<InvestPriceCostModel>();
        //��������б�Ϊ��
        List<InvestPriceCostRequest> priceList = requestData.getInvestPriceList();
        if (!CollectionUtils.isEmpty(priceList)) {
            for (InvestPriceCostRequest price : priceList) {
                priceCostModelList.add(composePriceCostModel(model, price));
            }
        }
        //��������б�Ϊ��
        List<InvestPriceCostRequest> costList = requestData.getInvestCostList();
        if (!CollectionUtils.isEmpty(costList)) {
            for (InvestPriceCostRequest cost : costList) {
                priceCostModelList.add(composePriceCostModel(model, cost));
            }
        }
        //��������õ��ۻ����ͳһ�ں����������������
        model.setNewInvestPriceCostModels(priceCostModelList);

        //�ʽ���Դ�˻�
        List<InvestFromAccountModel> fromAccountModels = new ArrayList<InvestFromAccountModel>();
        List<FromAccountRequest> fromAcconts = requestData.getFromAccountList();
        for (FromAccountRequest fromAccont : fromAcconts) {
            fromAccountModels.add(composeInvestFromAccountModel(model, fromAccont));
        }
        model.setInvstFromAccountModels(fromAccountModels);

        return model;
    }

    /**
     * ��װͶ�꽻����־ģ��
     * 
     * @param model
     * @param priceCostRequestData
     * @return
     */
    private InvestPriceCostModel composePriceCostModel(InvestRecordModel model,
                                                       InvestPriceCostRequest priceCostRequestData) {
        //����������ȡ������
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
     * ��װ�ʽ���Դģ��
     * 
     * @param investRecordModel
     * @param fromAccont
     * @return
     */
    private InvestFromAccountModel composeInvestFromAccountModel(InvestRecordModel investRecordModel,
                                                                 FromAccountRequest fromAccont) {
        //����������ȡ������
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
