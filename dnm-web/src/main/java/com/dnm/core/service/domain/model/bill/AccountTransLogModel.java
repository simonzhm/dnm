/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;
import java.util.Date;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.facade.constant.CurrencyEnum;

/**
 * 账务交易日志领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class AccountTransLogModel extends DomainModel {
    /** id */
    private String       id;

    /** 用户ID */
    private String       userId;

    /** 主业务ID */
    private String       guid;

    /** 业务ID */
    private String       bizId;

    /** 交易类型 */
    private String       transCode;

    /** 子交易类型 */
    private String       transSubCode;

    /** 交易金额 */
    private BigDecimal   transAmt;

    /** 交易币种 */
    private String       transCurrency;

    /** 业务发生时间 */
    private Date         transTime;

    /** 借方账号 */
    private String       debitAccount;

    /** 贷方账号 */
    private String       creditAccount;

    /** 备注 */
    private String       memo;

    /** 借方账号模型 */
    private AccountModel debitAccountModel;

    /** 贷方账号模型 */
    private AccountModel creditAccountModel;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.id is empty");
        AssertUtil.notBlank(userId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.userId is empty");
        AssertUtil.notBlank(guid, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.guid is empty");
        AssertUtil.notBlank(bizId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.bizId is empty");
        AssertUtil.notBlank(transCode, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transCode is empty");
        AssertUtil.notBlank(transSubCode, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transSubCode is empty");
        AssertUtil.isTrue(transAmt.compareTo(new BigDecimal(0)) > 0,
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transAmt must greater than 0");
        AssertUtil.notBlank(transCurrency, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.currency is empty");
        AssertUtil.notNull(CurrencyEnum.getByCode(transCurrency),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "AccountTransLogModel.currency is illegle");
        AssertUtil.notNull(transTime, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transTime is null");
        AssertUtil.notBlank(debitAccount, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.debitAccount is empty");
        AssertUtil.notBlank(creditAccount, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.creditAccount is empty");

        debitAccountModel.checkConsistency();
        creditAccountModel.checkConsistency();
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
     * Getter method for property <tt>guid</tt>.
     * 
     * @return property value of guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Setter method for property <tt>guid</tt>.
     * 
     * @param guid value to be assigned to property guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

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
     * Getter method for property <tt>transCode</tt>.
     * 
     * @return property value of transCode
     */
    public String getTransCode() {
        return transCode;
    }

    /**
     * Setter method for property <tt>transCode</tt>.
     * 
     * @param transCode value to be assigned to property transCode
     */
    public void setTransCode(String transCode) {
        this.transCode = transCode;
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
     * Getter method for property <tt>transTime</tt>.
     * 
     * @return property value of transTime
     */
    public Date getTransTime() {
        return transTime;
    }

    /**
     * Setter method for property <tt>transTime</tt>.
     * 
     * @param transTime value to be assigned to property transTime
     */
    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    /**
     * Getter method for property <tt>debitAccount</tt>.
     * 
     * @return property value of debitAccount
     */
    public String getDebitAccount() {
        return debitAccount;
    }

    /**
     * Setter method for property <tt>debitAccount</tt>.
     * 
     * @param debitAccount value to be assigned to property debitAccount
     */
    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    /**
     * Getter method for property <tt>creditAccount</tt>.
     * 
     * @return property value of creditAccount
     */
    public String getCreditAccount() {
        return creditAccount;
    }

    /**
     * Setter method for property <tt>creditAccount</tt>.
     * 
     * @param creditAccount value to be assigned to property creditAccount
     */
    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
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

    /**
     * Getter method for property <tt>debitAccountModel</tt>.
     * 
     * @return property value of debitAccountModel
     */
    public AccountModel getDebitAccountModel() {
        return debitAccountModel;
    }

    /**
     * Setter method for property <tt>debitAccountModel</tt>.
     * 
     * @param debitAccountModel value to be assigned to property debitAccountModel
     */
    public void setDebitAccountModel(AccountModel debitAccountModel) {
        this.debitAccountModel = debitAccountModel;
    }

    /**
     * Getter method for property <tt>creditAccountModel</tt>.
     * 
     * @return property value of creditAccountModel
     */
    public AccountModel getCreditAccountModel() {
        return creditAccountModel;
    }

    /**
     * Setter method for property <tt>creditAccountModel</tt>.
     * 
     * @param creditAccountModel value to be assigned to property creditAccountModel
     */
    public void setCreditAccountModel(AccountModel creditAccountModel) {
        this.creditAccountModel = creditAccountModel;
    }

}
