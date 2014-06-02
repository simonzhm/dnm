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
 * find the corresponding configuration file (<tt>tables/dnm_account.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmAccountDO</tt> object to DB table <tt>dnm_account</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_account(user_id,account_id,account_name,account_type,sub_account_type,balance,currency,direction,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmAccount
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmAccountDO dnmAccount) throws DataAccessException {
    	if (dnmAccount == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-ACCOUNT-INSERT", dnmAccount);

        return dnmAccount.getAccountId();
    }	
	 *  Update DB table <tt>dnm_account</tt>.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update dnm_account set user_id=?, account_name=?, account_type=?, sub_account_type=?, balance=?, currency=?, direction=?, gmt_create=?, gmt_modified=? where (account_id = ?)</tt>
	 *
	 *	@param dnmAccount
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(DnmAccountDO dnmAccount) throws DataAccessException {
    	if (dnmAccount == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-DNM-ACCOUNT-UPDATE", dnmAccount);
    }	
	 *  Query DB table <tt>dnm_account</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select user_id, account_id, account_name, account_type, sub_account_type, balance, currency, direction, gmt_create, gmt_modified from dnm_account where (account_id = ?)</tt>
	 *
	 *	@param accountId
	 *	@return DnmAccountDO
	 *	@throws DataAccessException
	 */	 
    public DnmAccountDO load(String accountId) throws DataAccessException {

        return (DnmAccountDO) getSqlMapClientTemplate().queryForObject("MS-DNM-ACCOUNT-LOAD", accountId);

    }	
	 *  Query DB table <tt>dnm_account</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select user_id, account_id, account_name, account_type, sub_account_type, balance, currency, direction, gmt_create, gmt_modified from dnm_account where (account_id = ?)</tt>
	 *
	 *	@param accountId
	 *	@return DnmAccountDO
	 *	@throws DataAccessException
	 */	 
    public DnmAccountDO active(String accountId) throws DataAccessException {

        return (DnmAccountDO) getSqlMapClientTemplate().queryForObject("MS-DNM-ACCOUNT-ACTIVE", accountId);

    }	