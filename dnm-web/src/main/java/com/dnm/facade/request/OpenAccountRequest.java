/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * �������󵥾�
 * 
 * @author hongmin.zhonghm
 * @version $Id: OpenAccountRequest.java, v 0.1 2014-5-5 ����10:54:38 hongmin.zhonghm Exp $
 */
public class OpenAccountRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** �˻��� */
    @RequestFieldCheck(notEmpty = true)
    private String            accountName;

    /** �˻�����  SubAccountTypeEnum*/
    @RequestFieldCheck(notEmpty = true)
    private String            accountType;

    /** ��� >=0 */
    @RequestFieldCheck(integer = true)
    private String            balance;

    /** ���� */
    @RequestFieldCheck(notEmpty = true)
    private String            currency;

    /** �˻����� */
    @RequestFieldCheck(notEmpty = true)
    private String            direction;

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

}
