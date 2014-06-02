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
 * find the corresponding configuration file (<tt>tables/dnm_invest_rcd.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmInvestRcdDO</tt> object to DB table <tt>dnm_invest_rcd</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_invest_rcd(id,user_id,platform_user_id,period,period_type,repay_method,invest_amt,invest_date,interest_rate,interest_amt,cost_amt,price_amt,fee_rate,is_finish,remark,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmInvestRcd
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmInvestRcdDO dnmInvestRcd) throws DataAccessException {
    	if (dnmInvestRcd == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-INVEST-RCD-INSERT", dnmInvestRcd);

        return dnmInvestRcd.getId();
    }	
	 *  Query DB table <tt>dnm_invest_rcd</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, platform_user_id, period, period_type, repay_method, invest_amt, invest_date, interest_rate, interest_amt, cost_amt, price_amt, fee_rate, is_finish, remark, gmt_create, gmt_modified from dnm_invest_rcd where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmInvestRcdDO
	 *	@throws DataAccessException
	 */	 
    public DnmInvestRcdDO load(String id) throws DataAccessException {

        return (DnmInvestRcdDO) getSqlMapClientTemplate().queryForObject("MS-DNM-INVEST-RCD-LOAD", id);

    }	