/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.dataobject;

// auto generated imports
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * A data object class directly models database table <tt>dnm_bank</tt>.
 *
 * This file is generated by <tt>iwallet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dnm_bank.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
public class DnmBankDO {

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.
	 */
	private String id;

	/**
	 * This property corresponds to db column <tt>user_id</tt>.
	 */
	private String userId;

	/**
	 * This property corresponds to db column <tt>bank_id</tt>.
	 */
	private String bankId;

	/**
	 * This property corresponds to db column <tt>bank_name</tt>.
	 */
	private String bankName;

	/**
	 * This property corresponds to db column <tt>direction</tt>.
	 */
	private String direction;

	/**
	 * This property corresponds to db column <tt>account_id</tt>.
	 */
	private String accountId;

	/**
	 * This property corresponds to db column <tt>bill_date</tt>.
	 */
	private String billDate;

	/**
	 * This property corresponds to db column <tt>repay_date</tt>.
	 */
	private String repayDate;

	/**
	 * This property corresponds to db column <tt>gmt_create</tt>.
	 */
	private Date gmtCreate;

	/**
	 * This property corresponds to db column <tt>gmt_modified</tt>.
	 */
	private Date gmtModified;

    //========== getters and setters ==========

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
     * Getter method for property <tt>gmtCreate</tt>.
     *
     * @return property value of gmtCreate
     */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	/**
	 * Setter method for property <tt>gmtCreate</tt>.
	 * 
	 * @param gmtCreate value to be assigned to property gmtCreate
     */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

    /**
     * Getter method for property <tt>gmtModified</tt>.
     *
     * @return property value of gmtModified
     */
	public Date getGmtModified() {
		return gmtModified;
	}
	
	/**
	 * Setter method for property <tt>gmtModified</tt>.
	 * 
	 * @param gmtModified value to be assigned to property gmtModified
     */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
