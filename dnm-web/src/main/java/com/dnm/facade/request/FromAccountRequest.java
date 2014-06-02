/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

/**
 * �ʽ���Դ���󵥾�
 * 
 * @author hongmin.zhonghm
 * @version $Id: FromAccountRequest.java, v 0.1 2014-5-25 ����7:06:36 hongmin.zhonghm Exp $
 */
public class FromAccountRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -1283090538604646047L;

    /** �˻�ID */
    private String            accountId;

    /** ���  */
    private String            amount;

    /** ���� */
    private String            currency;

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
    public String getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(String amount) {
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
