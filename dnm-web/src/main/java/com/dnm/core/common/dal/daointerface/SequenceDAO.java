/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.daointerface;

// auto generated imports
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>sequence</tt>.
 *
 * This file is generated by <tt>iwallet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/sequence.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
public interface SequenceDAO {
	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmUserNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmAccountNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmBankNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmPlatformNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmPlatformUserNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmAccountTransLogNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmAccountLogNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmInvestPriceCostNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmInvestRcdNextval() throws DataAccessException;

	/**
	 *  Query DB table <tt>sequence</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from sequence</tt>
	 *
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getDnmInvestDueinRcdNextval() throws DataAccessException;

}