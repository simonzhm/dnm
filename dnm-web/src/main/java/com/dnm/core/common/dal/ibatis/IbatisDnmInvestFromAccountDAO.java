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
 * find the corresponding configuration file (<tt>tables/dnm_invest_from_account.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmInvestFromAccountDO</tt> object to DB table <tt>dnm_invest_from_account</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_invest_from_account(invest_record_id,account_id,amount,currency,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmInvestFromAccount
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmInvestFromAccountDO dnmInvestFromAccount) throws DataAccessException {
    	if (dnmInvestFromAccount == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-INVEST-FROM-ACCOUNT-INSERT", dnmInvestFromAccount);

        return dnmInvestFromAccount.getAccountId();
    }	
	 *  Query DB table <tt>dnm_invest_from_account</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select invest_record_id, account_id, amount, currency, gmt_create, gmt_modified from dnm_invest_from_account where ((invest_record_id = ?) AND (account_id = ?))</tt>
	 *
	 *	@param investRecordId
	 *	@param accountId
	 *	@return DnmInvestFromAccountDO
	 *	@throws DataAccessException
	 */	 
    public DnmInvestFromAccountDO load(String investRecordId, String accountId) throws DataAccessException {
        Map param = new HashMap();

        param.put("investRecordId", investRecordId);
        param.put("accountId", accountId);

        return (DnmInvestFromAccountDO) getSqlMapClientTemplate().queryForObject("MS-DNM-INVEST-FROM-ACCOUNT-LOAD", param);

    }	