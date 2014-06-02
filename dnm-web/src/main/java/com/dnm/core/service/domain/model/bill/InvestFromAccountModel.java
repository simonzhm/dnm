/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;

import com.dnm.core.common.constant.LengthDefineConstant;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AmountUtil;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.facade.constant.CurrencyEnum;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestFromAccountModel.java, v 0.1 2014-5-25 下午5:12:32 hongmin.zhonghm Exp $
 */
public class InvestFromAccountModel extends DomainModel {

    /** 投标记录ID */
    private String     investRecordId;

    /** 账户ID */
    private String     accountId;

    /** 金额 */
    private BigDecimal amount;

    /** 币种 */
    private String     currency;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(investRecordId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestFromAccountModel.investRecordId is null");

        AssertUtil.isTrue(StringUtil.isMeetLength(accountId, LengthDefineConstant.ACCOUNT_LENGTH),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestFromAccountModel.accountId is illegal");

        AssertUtil.isTrue(AmountUtil.isGreaterThanZero(amount),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestFromAccountModel.amount must greater than 0");

        AssertUtil
            .notNull(CurrencyEnum.getByCode(currency), ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "InvestFromAccountModel.currency is illegal");
    }

    /**
     * Getter method for property <tt>investRecordId</tt>.
     * 
     * @return property value of investRecordId
     */
    public String getInvestRecordId() {
        return investRecordId;
    }

    /**
     * Setter method for property <tt>investRecordId</tt>.
     * 
     * @param investRecordId value to be assigned to property investRecordId
     */
    public void setInvestRecordId(String investRecordId) {
        this.investRecordId = investRecordId;
    }

    /**
     * Getter method for property <tt>accountId</tt>.
     * 
     * @return property value of accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Setter method for property <tt>accountId</tt>.
     * 
     * @param accountId value to be assigned to property accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Getter method for property <tt>currency</tt>.
     * 
     * @return property value of currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter method for property <tt>currency</tt>.
     * 
     * @param currency value to be assigned to property currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
