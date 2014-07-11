/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.cache.SubTransCodeMapCache;
import com.dnm.core.common.constant.AccountTransRuleEnum;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AmountUtil;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.CalculateUtil;
import com.dnm.core.common.util.DateUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.SequenceService;
import com.dnm.core.service.domain.model.bill.InvestDueinRecordModel;
import com.dnm.core.service.domain.model.bill.InvestPriceCostModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.facade.api.AccountServiceFacade;
import com.dnm.facade.api.AccountTransferServiceFacade;
import com.dnm.facade.constant.AccountTransCodeEnum;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.constant.SubAccountTransCodeEnum;
import com.dnm.facade.constant.ThirdAccountTypeEnum;
import com.dnm.facade.request.AccountTransferRequest;
import com.dnm.facade.request.QueryAccountByUserIdTypeRequest;
import com.dnm.facade.result.AccountResult;
import com.dnm.facade.vo.AccountVO;

/**
 * ����Ͷ����ϸ������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseSplitProcessor.java, v 0.1 2014-5-27 ����12:22:10 hongmin.zhonghm Exp $
 */
public abstract class BaseSplitProcessor implements SplitProcessor {
    /** sequence���� */
    @Resource
    protected SequenceService      sequenceService;

    /** �˻����� */
    @Resource
    protected AccountServiceFacade accountServiceFacade;

    /** ������� */
    @Resource
    AccountTransferServiceFacade   accountTransferServiceFacade;

    /** �ӽ�����ӳ�仺�� */
    @Resource
    protected SubTransCodeMapCache subTransCodeMapCache;

    /**
     * �����û�id�Լ��˻������ͻ�ȡ�˻�
     * 
     * @param userId
     * @param thirdAccountType
     * @return
     */
    protected AccountVO getAccount(String userId, String thirdAccountType) {
        String errorMsg = "userId:" + userId + ",thirdAccountType:" + thirdAccountType;
        QueryAccountByUserIdTypeRequest request = new QueryAccountByUserIdTypeRequest();
        request.setUserId(userId);
        request.setSubAccountType(thirdAccountType);
        AccountResult result = accountServiceFacade.queryAccountByUserIdType(request);
        AssertUtil.isTrue(ResultHelper.isSuccess(result), ResultCodeEnum.ACCOUNT_QUERY_FAIL,
            errorMsg);
        AssertUtil.notNull(result.getAccount(), ResultCodeEnum.ACCOUNT_NOT_EXISTS, errorMsg);
        return result.getAccount();
    }

    /**
     * ��������ü���
     * 
     * @param mainRcd
     * @param priceCost
     * @return
     */
    protected void accountTransPriceCost(InvestRecordModel mainRcd, InvestPriceCostModel priceCost) {
        String transSubCode = priceCost.getTransSubCode();
        String isFinish = priceCost.getIsFinish();
        List<String> accountTransSubCodes = subTransCodeMapCache.getAccountTransSubCodes(transSubCode);
        
        AssertUtil.notEmpty(accountTransSubCodes, ResultCodeEnum.TRANS_CODE_MAP_ERROR, "biz transcode = " + transSubCode + ",isFinish = " + isFinish);
        
        for (String atsb : accountTransSubCodes) {
            TransInfo transInfo = new TransInfo();
            transInfo.setBizId(priceCost.getBizId());
            transInfo.setTransSubCode(atsb);
            transInfo.setTransAmt(priceCost.getTransAmt());
            transInfo.setTransCurrency(priceCost.getTransCurrency());
            transInfo.setMemo(priceCost.getMemo());

            AccountTransferRequest request = genAccountTransferRequest(mainRcd, transInfo);

            AssertUtil.isTrue(
                ResultHelper.isSuccess(accountTransferServiceFacade.transfer(request)),
                ResultCodeEnum.ACCOUNT_TRANS_FAIL, "price cost request data:" + request);
        }
    }

    /**
     * ����������ؽ����������ã���Ϣ��������Ľ��ֻ��Ϊչʾ�ο���ʵ�ʽ��������䶯
     * 
     * @param mainRcd
     */
    protected void updateMainRcdAmount(InvestRecordModel mainRcd) {
        //����������б�
        List<InvestPriceCostModel> priceCosts = mainRcd.getNewInvestPriceCostModels();
        BigDecimal priceAmt = new BigDecimal("0");
        BigDecimal costAmt = new BigDecimal("0");
        for (InvestPriceCostModel priceCost : priceCosts) {
            if (StringUtil.equals(priceCost.getTransCode(), AccountTransCodeEnum.INCOME.getCode())) {
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
    protected void account(InvestRecordModel mainRcd) {
        //����������б�
        List<InvestPriceCostModel> priceCosts = mainRcd.getNewInvestPriceCostModels();
        for (InvestPriceCostModel priceCost : priceCosts) {
            accountTransPriceCost(mainRcd, priceCost);
        }

        //Ͷ��
        accountTransInvest(mainRcd);

    }

    /**
     * Ͷ�꣬��:�������  ��:�������
     * ������Ϣ����:�������  ��:������Ϣ 
     * 
     * @param mainRcd
     * @return
     */
    protected void accountTransInvest(InvestRecordModel mainRcd) {
        AccountTransferRequest request = null;
        TransInfo transInfo = null;
        //Ͷ��
        transInfo = new TransInfo();
        transInfo.setBizId(mainRcd.getId());
        transInfo.setTransSubCode(SubAccountTransCodeEnum.NORMAL_INVEST.getCode());
        transInfo.setTransAmt(mainRcd.getInvestAmt());
        transInfo.setTransCurrency(CurrencyEnum.CNY.getCode());
        transInfo.setMemo(mainRcd.getRemark());
        request = genAccountTransferRequest(mainRcd, transInfo);
        AssertUtil.isTrue(ResultHelper.isSuccess(accountTransferServiceFacade.transfer(request)),
            ResultCodeEnum.ACCOUNT_TRANS_FAIL, "invest request data:" + request);

        //������Ϣ
        transInfo = new TransInfo();
        transInfo.setBizId(mainRcd.getId());
        transInfo.setTransSubCode(SubAccountTransCodeEnum.DUEIN_INTEREST.getCode());
        transInfo.setTransAmt(mainRcd.getInterestAmt());
        transInfo.setTransCurrency(CurrencyEnum.CNY.getCode());
        transInfo.setMemo(mainRcd.getRemark());
        request = genAccountTransferRequest(mainRcd, transInfo);
        AssertUtil.isTrue(ResultHelper.isSuccess(accountTransferServiceFacade.transfer(request)),
            ResultCodeEnum.ACCOUNT_TRANS_FAIL, "duein interest request data:" + request);
    }

    /**
     * �����������
     * 
     * @param mainRcd
     * @param transInfo
     * @return
     */
    protected AccountTransferRequest genAccountTransferRequest(InvestRecordModel mainRcd,
                                                               TransInfo transInfo) {
        String userId = mainRcd.getPlatformUserModel().getUserId();
        String transSubCode = transInfo.getTransSubCode();
        AccountTransRuleEnum transRule = AccountTransRuleEnum.getByCode(transSubCode);

        AccountTransferRequest request = new AccountTransferRequest();

        ThirdAccountTypeEnum debitAccountType = transRule.getDebitSubAccountType();
        ThirdAccountTypeEnum creditAccountType = transRule.getCreditSubAccountType();
        request.setUserId(mainRcd.getPlatformUserModel().getUserId());
        request.setGuid(mainRcd.getId());
        request.setBizId(transInfo.getBizId());
        request.setTransCode(StringUtil.substring(transInfo.getTransSubCode(), 0, 2));
        request.setTransSubCode(transInfo.getTransSubCode());
        request.setTransAmt(transInfo.getTransAmt().toString());
        request.setTransCurrency(transInfo.getTransCurrency());
        request.setTransTime(DateUtil.getDefaultDateString(mainRcd.getGmtCreate()));
        request.setDebitAccount(getAccount(userId, debitAccountType.getCode()).getAccountId());
        request.setCreditAccount(getAccount(userId, creditAccountType.getCode()).getAccountId());
        request.setMemo(transInfo.getMemo());
        return request;
    }

    /**
     * ���˲�����Ϣ
     * 
     * @author hongmin.zhonghm
     * @version $Id: BaseSplitProcessor.java, v 0.1 2014-6-10 ����9:55:01 hongmin.zhonghm Exp $
     */
    class TransInfo {
        /** ҵ��� */
        private String     bizId;
        /** �����ӽ����� */
        private String     transSubCode;
        /** ���׽�� */
        private BigDecimal transAmt;
        /** ���ױ��� */
        private String     transCurrency;
        /** ��ע */
        private String     memo;

        /**
         * Getter method for property <tt>bizId</tt>.
         * 
         * @return property value of bizId
         */
        public String getBizId() {
            return bizId;
        }

        /**
         * Setter method for property <tt>bizId</tt>.
         * 
         * @param bizId value to be assigned to property bizId
         */
        public void setBizId(String bizId) {
            this.bizId = bizId;
        }

        /**
         * Getter method for property <tt>transSubCode</tt>.
         * 
         * @return property value of transSubCode
         */
        public String getTransSubCode() {
            return transSubCode;
        }

        /**
         * Setter method for property <tt>transSubCode</tt>.
         * 
         * @param transSubCode value to be assigned to property transSubCode
         */
        public void setTransSubCode(String transSubCode) {
            this.transSubCode = transSubCode;
        }

        /**
         * Getter method for property <tt>transAmt</tt>.
         * 
         * @return property value of transAmt
         */
        public BigDecimal getTransAmt() {
            return transAmt;
        }

        /**
         * Setter method for property <tt>transAmt</tt>.
         * 
         * @param transAmt value to be assigned to property transAmt
         */
        public void setTransAmt(BigDecimal transAmt) {
            this.transAmt = transAmt;
        }

        /**
         * Getter method for property <tt>transCurrency</tt>.
         * 
         * @return property value of transCurrency
         */
        public String getTransCurrency() {
            return transCurrency;
        }

        /**
         * Setter method for property <tt>transCurrency</tt>.
         * 
         * @param transCurrency value to be assigned to property transCurrency
         */
        public void setTransCurrency(String transCurrency) {
            this.transCurrency = transCurrency;
        }

        /**
         * Getter method for property <tt>memo</tt>.
         * 
         * @return property value of memo
         */
        public String getMemo() {
            return memo;
        }

        /**
         * Setter method for property <tt>memo</tt>.
         * 
         * @param memo value to be assigned to property memo
         */
        public void setMemo(String memo) {
            this.memo = memo;
        }

    }
}
