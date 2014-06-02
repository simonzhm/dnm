/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;
import java.util.List;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AmountUtil;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.facade.constant.AccountDirectionEnum;
import com.dnm.facade.constant.CurrencyEnum;

/**
 * 账户领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class AccountModel extends DomainModel {

    /** 用户ID */
    private String                userId;

    /** 账户ID */
    private String                accountId;

    /** 账户名称 */
    private String                accountName;

    /** 账户类型 */
    private String                accountType;

    /** 账户子类型 */
    private String                subAccountType;

    /** 余额 */
    private BigDecimal            balance;

    /** 币种 */
    private String                currency;

    /** 账户方向 */
    private String                direction;

    /** 账户日志模型 */
    private AccountLogModel       accountLogModel;

    /** 账户历史日志模型 */
    private List<AccountLogModel> accountLogModels;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(userId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountModel.userId is empty");
        AssertUtil.notBlank(accountId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountModel.accountId is empty");
        AssertUtil.notBlank(accountName, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountModel.accountName is empty");
        AssertUtil.isTrue(StringUtil.isMeetLength(accountType, 2),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "AccountModel.accountType is illegal");
        AssertUtil.isTrue(StringUtil.isMeetLength(subAccountType, 4),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "AccountModel.subAccountType is illegal");
        AssertUtil.isTrue(balance.compareTo(new BigDecimal(0)) >= 0,
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountModel.balance must greater than or equals 0");
        AssertUtil.notBlank(currency, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountModel.currency is empty");
        AssertUtil.notNull(CurrencyEnum.getByCode(currency),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "AccountModel.currency is illegle");
        AssertUtil.notBlank(direction, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountModel.direction is empty");
        AssertUtil.notNull(AccountDirectionEnum.getByCode(direction),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "AccountModel.direction is illegle");

        if (accountLogModel != null) {
            accountLogModel.checkConsistency();
        }
    }

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#amountBalanceCheck()
     */
    @Override
    protected void amountBalanceCheck() {
        super.amountBalanceCheck();
        if (StringUtil.equals(direction, AccountDirectionEnum.DEBIT.getCode())) {
            AssertUtil.isTrue(AmountUtil.isGreaterThanZero(balance),
                ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "amount of debit account must be greater than 0 [" + accountId + "]");
        }
    }

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     * 
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * Getter method for property <tt>accountName</tt>.
     * 
     * @return property value of accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Setter method for property <tt>accountName</tt>.
     * 
     * @param accountName value to be assigned to property accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Getter method for property <tt>accountType</tt>.
     * 
     * @return property value of accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Setter method for property <tt>accountType</tt>.
     * 
     * @param accountType value to be assigned to property accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Getter method for property <tt>subAccountType</tt>.
     * 
     * @return property value of subAccountType
     */
    public String getSubAccountType() {
        return subAccountType;
    }

    /**
     * Setter method for property <tt>subAccountType</tt>.
     * 
     * @param subAccountType value to be assigned to property subAccountType
     */
    public void setSubAccountType(String subAccountType) {
        this.subAccountType = subAccountType;
    }

    /**
     * Getter method for property <tt>balance</tt>.
     * 
     * @return property value of balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Setter method for property <tt>balance</tt>.
     * 
     * @param balance value to be assigned to property balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    /**
     * Getter method for property <tt>direction</tt>.
     * 
     * @return property value of direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Setter method for property <tt>direction</tt>.
     * 
     * @param direction value to be assigned to property direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Getter method for property <tt>accountLogModel</tt>.
     * 
     * @return property value of accountLogModel
     */
    public AccountLogModel getAccountLogModel() {
        return accountLogModel;
    }

    /**
     * Setter method for property <tt>accountLogModel</tt>.
     * 
     * @param accountLogModel value to be assigned to property accountLogModel
     */
    public void setAccountLogModel(AccountLogModel accountLogModel) {
        this.accountLogModel = accountLogModel;
    }

    /**
     * Getter method for property <tt>accountLogModels</tt>.
     * 
     * @return property value of accountLogModels
     */
    public List<AccountLogModel> getAccountLogModels() {
        return accountLogModels;
    }

    /**
     * Setter method for property <tt>accountLogModels</tt>.
     * 
     * @param accountLogModels value to be assigned to property accountLogModels
     */
    public void setAccountLogModels(List<AccountLogModel> accountLogModels) {
        this.accountLogModels = accountLogModels;
    }

}
