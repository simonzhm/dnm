/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.ibatis;
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
    public long getDnmUserNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-USER-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmAccountNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-ACCOUNT-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmBankNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-BANK-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmPlatformNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-PLATFORM-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmPlatformUserNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-PLATFORM-USER-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmAccountTransLogNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-ACCOUNT-TRANS-LOG-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmAccountLogNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-ACCOUNT-LOG-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmInvestPriceCostNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-INVEST-PRICE-COST-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmInvestRcdNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-INVEST-RCD-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	
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
    public long getDnmInvestDueinRcdNextval() throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SEQUENCE-GET-DNM-INVEST-DUEIN-RCD-NEXTVAL", null);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }	