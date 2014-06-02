/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.vo;

import java.math.BigDecimal;

/**
 * �˻�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountVO.java, v 0.1 2014-5-14 ����10:16:36 hongmin.zhonghm Exp $
 */
public class AccountVO {

    /** �û�ID */
    private String     userId;

    /** �˻�ID */
    private String     accountId;

    /** �˻����� */
    private String     accountName;

    /** �˻����� */
    private String     accountType;

    /** �˻������� */
    private String     subAccountType;

    /** ��� */
    private BigDecimal balance;

    /** ���� */
    private String     currency;

    /** �˻����� */
    private String     direction;

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
}
