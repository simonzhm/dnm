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
 * find the corresponding configuration file (<tt>tables/dnm_invest_duein_rcd.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmInvestDueinRcdDO</tt> object to DB table <tt>dnm_invest_duein_rcd</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_invest_duein_rcd(id,rcd_id,period_index,repay_amt,repay_interest_amt,repay_date,actual_repay_date,is_delay,is_finish,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmInvestDueinRcd
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmInvestDueinRcdDO dnmInvestDueinRcd) throws DataAccessException {
    	if (dnmInvestDueinRcd == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-INVEST-DUEIN-RCD-INSERT", dnmInvestDueinRcd);

        return dnmInvestDueinRcd.getId();
    }	
	 *  Query DB table <tt>dnm_invest_duein_rcd</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, rcd_id, period_index, repay_amt, repay_interest_amt, repay_date, actual_repay_date, is_delay, is_finish, gmt_create, gmt_modified from dnm_invest_duein_rcd where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmInvestDueinRcdDO
	 *	@throws DataAccessException
	 */	 
    public DnmInvestDueinRcdDO load(String id) throws DataAccessException {

        return (DnmInvestDueinRcdDO) getSqlMapClientTemplate().queryForObject("MS-DNM-INVEST-DUEIN-RCD-LOAD", id);

    }	