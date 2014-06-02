/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.facade.constant.AccountDirectionEnum;

/**
 * 银行领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class BankModel extends DomainModel {

    /** ID */
    private String       id;

    /** 用户ID */
    private String       userId;

    /** 银行简称ID,如CMB,ICBC */
    private String       bankId;

    /** 银行名称 */
    private String       bankName;

    /** 银行方向 */
    private String       direction;

    /** 账户ID */
    private String       accountId;

    /** 账单日期 */
    private String       billDate;

    /** 还款日期 */
    private String       repayDate;

    /** 账户领域模型 */
    private AccountModel accountModel;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "BankModel.id is empty");
        AssertUtil.notBlank(userId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "BankModel.userId is empty");
        AssertUtil.notBlank(bankId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "BankModel.bankId is empty");
        AssertUtil.notBlank(bankName, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "BankModel.bankName is empty");
        AssertUtil.notBlank(accountId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "BankModel.accountId is empty");
        AssertUtil.notBlank(direction, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "BankModel.direction is empty");
        AssertUtil.notNull(AccountDirectionEnum.getByCode(direction),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "AccountModel.direction is illegle");
        if (!StringUtil.isBlank(billDate)) {
            AssertUtil.notNull(billDate.length() == 2, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "BankModel.billDate's length illegle");
        }
        if (!StringUtil.isBlank(repayDate)) {
            AssertUtil.notNull(repayDate.length() == 2, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "BankModel.repayDate's length illegle");
        }
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
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
     * Getter method for property <tt>bankId</tt>.
     * 
     * @return property value of bankId
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * Setter method for property <tt>bankId</tt>.
     * 
     * @param bankId value to be assigned to property bankId
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * Getter method for property <tt>bankName</tt>.
     * 
     * @return property value of bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Setter method for property <tt>bankName</tt>.
     * 
     * @param bankName value to be assigned to property bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
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
     * Getter method for property <tt>billDate</tt>.
     * 
     * @return property value of billDate
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * Setter method for property <tt>billDate</tt>.
     * 
     * @param billDate value to be assigned to property billDate
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    /**
     * Getter method for property <tt>repayDate</tt>.
     * 
     * @return property value of repayDate
     */
    public String getRepayDate() {
        return repayDate;
    }

    /**
     * Setter method for property <tt>repayDate</tt>.
     * 
     * @param repayDate value to be assigned to property repayDate
     */
    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    /**
     * Getter method for property <tt>accountModel</tt>.
     * 
     * @return property value of accountModel
     */
    public AccountModel getAccountModel() {
        return accountModel;
    }

    /**
     * Setter method for property <tt>accountModel</tt>.
     * 
     * @param accountModel value to be assigned to property accountModel
     */
    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

}
