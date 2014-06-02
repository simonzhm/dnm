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
 * find the corresponding configuration file (<tt>tables/dnm_account_log.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmAccountLogDO</tt> object to DB table <tt>dnm_account_log</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_account_log(id,trans_log_id,direction,account,trans_amt,balance,memo,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmAccountLog
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmAccountLogDO dnmAccountLog) throws DataAccessException {
    	if (dnmAccountLog == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-ACCOUNT-LOG-INSERT", dnmAccountLog);

        return dnmAccountLog.getId();
    }	
	 *  Query DB table <tt>dnm_account_log</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, trans_log_id, direction, account, trans_amt, balance, memo, gmt_create, gmt_modified from dnm_account_log where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmAccountLogDO
	 *	@throws DataAccessException
	 */	 
    public DnmAccountLogDO load(String id) throws DataAccessException {

        return (DnmAccountLogDO) getSqlMapClientTemplate().queryForObject("MS-DNM-ACCOUNT-LOG-LOAD", id);

    }	