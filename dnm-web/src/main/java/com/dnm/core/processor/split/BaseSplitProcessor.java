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
 * 基础投标明细处理类
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseSplitProcessor.java, v 0.1 2014-5-27 上午12:22:10 hongmin.zhonghm Exp $
 */
public abstract class BaseSplitProcessor implements SplitProcessor {
    /** sequence服务 */
    @Resource
    protected SequenceService      sequenceService;

    /** 账户服务 */
    @Resource
    protected AccountServiceFacade accountServiceFacade;

    /** 账务服务 */
    @Resource
    AccountTransferServiceFacade   accountTransferServiceFacade;

    /** 子交易码映射缓存 */
    @Resource
    protected SubTransCodeMapCache subTransCodeMapCache;

    /**
     * 根据用户id以及账户子类型获取账户
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
     * 奖励与费用记账
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
     * 更新主标相关金额（奖励，费用，利息），这里的金额只做为展示参考，实际金额会有所变动
     * 
     * @param mainRcd
     */
    protected void updateMainRcdAmount(InvestRecordModel mainRcd) {
        //奖励与费用列表
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

        //预算利息及利息管理费，由于每个明细标在确认时的费率会变动，比如用户级别达到某一高度时，费率有所优惠，所以这里只是参考
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
        //利息
        mainRcd.setInterestAmt(interestAmt);
        //利息管理费
        mainRcd.setCostAmt(AmountUtil.add(mainRcd.getCostAmt(), interestFeeAmt));
    }

    /**
     * 记账
     * 
     * @param mainRcd
     */
    protected void account(InvestRecordModel mainRcd) {
        //奖励与费用列表
        List<InvestPriceCostModel> priceCosts = mainRcd.getNewInvestPriceCostModels();
        for (InvestPriceCostModel priceCost : priceCosts) {
            accountTransPriceCost(mainRcd, priceCost);
        }

        //投标
        accountTransInvest(mainRcd);

    }

    /**
     * 投标，借:待收余额  贷:可用余额
     * 待收利息，借:待收余额  贷:待收利息 
     * 
     * @param mainRcd
     * @return
     */
    protected void accountTransInvest(InvestRecordModel mainRcd) {
        AccountTransferRequest request = null;
        TransInfo transInfo = null;
        //投标
        transInfo = new TransInfo();
        transInfo.setBizId(mainRcd.getId());
        transInfo.setTransSubCode(SubAccountTransCodeEnum.NORMAL_INVEST.getCode());
        transInfo.setTransAmt(mainRcd.getInvestAmt());
        transInfo.setTransCurrency(CurrencyEnum.CNY.getCode());
        transInfo.setMemo(mainRcd.getRemark());
        request = genAccountTransferRequest(mainRcd, transInfo);
        AssertUtil.isTrue(ResultHelper.isSuccess(accountTransferServiceFacade.transfer(request)),
            ResultCodeEnum.ACCOUNT_TRANS_FAIL, "invest request data:" + request);

        //待收利息
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
     * 构造记账请求
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
     * 记账差异信息
     * 
     * @author hongmin.zhonghm
     * @version $Id: BaseSplitProcessor.java, v 0.1 2014-6-10 上午9:55:01 hongmin.zhonghm Exp $
     */
    class TransInfo {
        /** 业务号 */
        private String     bizId;
        /** 账务子交易码 */
        private String     transSubCode;
        /** 交易金额 */
        private BigDecimal transAmt;
        /** 交易币种 */
        private String     transCurrency;
        /** 备注 */
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
