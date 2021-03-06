/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.dataobject;

// auto generated imports
import java.util.Date;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * A data object class directly models database table <tt>dnm_account_trans_log</tt>.
 *
 * This file is generated by <tt>iwallet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dnm_account_trans_log.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
public class DnmAccountTransLogDO {

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
	 * This property corresponds to db column <tt>guid</tt>.
	 */
	private String guid;

	/**
	 * This property corresponds to db column <tt>biz_id</tt>.
	 */
	private String bizId;

	/**
	 * This property corresponds to db column <tt>trans_code</tt>.
	 */
	private String transCode;

	/**
	 * This property corresponds to db column <tt>trans_sub_code</tt>.
	 */
	private String transSubCode;

	/**
	 * This property corresponds to db column <tt>trans_amt</tt>.
	 */
	private BigDecimal transAmt;

	/**
	 * This property corresponds to db column <tt>trans_currency</tt>.
	 */
	private String transCurrency;

	/**
	 * This property corresponds to db column <tt>trans_time</tt>.
	 */
	private Date transTime;

	/**
	 * This property corresponds to db column <tt>debit_account</tt>.
	 */
	private String debitAccount;

	/**
	 * This property corresponds to db column <tt>credit_account</tt>.
	 */
	private String creditAccount;

	/**
	 * This property corresponds to db column <tt>memo</tt>.
	 */
	private String memo;

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
