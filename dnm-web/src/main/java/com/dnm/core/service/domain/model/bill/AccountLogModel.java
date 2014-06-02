/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AmountUtil;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 账务日志领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountLogModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class AccountLogModel extends DomainModel {
    /** id */
    private String     id;

    /** 账务交易日志ID */
    private String     transLogId;

    /** 交易方向 */
    private String     direction;

    /** 账号 */
    private String     account;

    /** 交易金额 */
    private BigDecimal transAmt;

    /** 账户余额 */
    private BigDecimal balance;

    /** 备注 */
    private String     memo;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountLogModel.id is empty");
        AssertUtil.notBlank(transLogId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountLogModel.transLogId is empty");
        AssertUtil.notBlank(direction, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountLogModel.direction is empty");
        AssertUtil.notBlank(account, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountLogModel.account is empty");
        AssertUtil.isTrue(AmountUtil.isGreaterThanZero(transAmt),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountLogModel.transAmt must be greater than 0");
        AssertUtil.notNull(balance, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountLogModel.balance is empty");
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
     * Getter method for property <tt>transLogId</tt>.
     * 
     * @return property value of transLogId
     */
    public String getTransLogId() {
        return transLogId;
    }

    /**
     * Setter method for property <tt>transLogId</tt>.
     * 
     * @param transLogId value to be assigned to property transLogId
     */
    public void setTransLogId(String transLogId) {
        this.transLogId = transLogId;
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
     * Getter method for property <tt>account</tt>.
     * 
     * @return property value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Setter method for property <tt>account</tt>.
     * 
     * @param account value to be assigned to property account
     */
    public void setAccount(String account) {
        this.account = account;
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
