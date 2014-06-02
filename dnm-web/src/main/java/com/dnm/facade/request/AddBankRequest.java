/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 添加银行请求单据
 * 
 * @author hongmin.zhonghm
 * @version $Id: AddBankRequest.java, v 0.1 2014-5-5 上午10:54:38 hongmin.zhonghm Exp $
 */
public class AddBankRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** 银行简称 如CMB,ICBC */
    @RequestFieldCheck(notEmpty = true)
    private String            bankId;

    /** 银行名称 */
    @RequestFieldCheck(notEmpty = true)
    private String            bankName;

    /** 账户方向 */
    @RequestFieldCheck(notEmpty = true)
    private String            direction;

    /** 初始余额 */
    private String            balance;

    /** 初始余额币种 */
    private String            currency;

    /** 账单日期 */
    private String            billDate;

    /** 还款日期  */
    private String            repayDate;

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
     * Getter method for property <tt>balance</tt>.
     * 
     * @return property value of balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * Setter method for property <tt>balance</tt>.
     * 
     * @param balance value to be assigned to property balance
     */
    public void setBalance(String balance) {
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

}
