/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 记账请求单据
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferRequest.java, v 0.1 2014-5-13 下午9:25:18 hongmin.zhonghm Exp $
 */
public class AccountTransferRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -8954497820505226630L;

    /** 主业务ID */
    @RequestFieldCheck(notEmpty = true, maxLength = 31)
    private String            guid;

    /** 子业务ID */
    @RequestFieldCheck(notEmpty = true, maxLength = 31)
    private String            bizId;

    /** 账务交易代码 */
    @RequestFieldCheck(notEmpty = true, length = 2)
    private String            transCode;

    /** 账务子交易代码 */
    @RequestFieldCheck(notEmpty = true, length = 6)
    private String            transSubCode;

    /** 交易金额 */
    @RequestFieldCheck(notEmpty = true)
    private String            transAmt;

    /** 交易币种 */
    @RequestFieldCheck(notEmpty = true, length = 3)
    private String            transCurrency;

    /** 业务发生时间 */
    @RequestFieldCheck(notEmpty = true)
    private String            transTime;

    /** 借方账号 */
    @RequestFieldCheck(notEmpty = true, length = 20)
    private String            debitAccount;

    /** 贷方账号 */
    @RequestFieldCheck(notEmpty = true, length = 20)
    private String            creditAccount;

    /** 备注 */
    private String            memo;

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
    public String getTransAmt() {
        return transAmt;
    }

    /**
     * Setter method for property <tt>transAmt</tt>.
     * 
     * @param transAmt value to be assigned to property transAmt
     */
    public void setTransAmt(String transAmt) {
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
     * Getter method for property <tt>transTime</tt>.
     * 
     * @return property value of transTime
     */
    public String getTransTime() {
        return transTime;
    }

    /**
     * Setter method for property <tt>transTime</tt>.
     * 
     * @param transTime value to be assigned to property transTime
     */
    public void setTransTime(String transTime) {
        this.transTime = transTime;
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

}
