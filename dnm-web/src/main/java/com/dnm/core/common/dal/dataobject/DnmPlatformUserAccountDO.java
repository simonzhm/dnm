/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.dataobject;

// auto generated imports
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * A data object class directly models database table <tt>dnm_platform_user_account</tt>.
 *
 * This file is generated by <tt>iwallet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dnm_platform_user_account.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
public class DnmPlatformUserAccountDO {

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>account_id</tt>.
	 */
	private String accountId;

	/**
	 * This property corresponds to db column <tt>sub_account_type</tt>.
	 */
	private String subAccountType;

	/**
	 * This property corresponds to db column <tt>platform_user_id</tt>.
	 */
	private String platformUserId;

    //========== getters and setters ==========

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
     * Getter method for property <tt>platformUserId</tt>.
     *
     * @return property value of platformUserId
     */
	public String getPlatformUserId() {
		return platformUserId;
	}
	
	/**
	 * Setter method for property <tt>platformUserId</tt>.
	 * 
	 * @param platformUserId value to be assigned to property platformUserId
     */
	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
