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
 * find the corresponding configuration file (<tt>tables/dnm_invest_price_cost.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmInvestPriceCostDO</tt> object to DB table <tt>dnm_invest_price_cost</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_invest_price_cost(id,guid,biz_id,trans_type,trans_sub_type,orig_trans_amt,trans_rate,trans_amt,trans_currency,memo,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmInvestPriceCost
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmInvestPriceCostDO dnmInvestPriceCost) throws DataAccessException {
    	if (dnmInvestPriceCost == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-INVEST-PRICE-COST-INSERT", dnmInvestPriceCost);

        return dnmInvestPriceCost.getId();
    }	
	 *  Query DB table <tt>dnm_invest_price_cost</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, guid, biz_id, trans_type, trans_sub_type, orig_trans_amt, trans_rate, trans_amt, trans_currency, memo, gmt_create, gmt_modified from dnm_invest_price_cost where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmInvestPriceCostDO
	 *	@throws DataAccessException
	 */	 
    public DnmInvestPriceCostDO load(String id) throws DataAccessException {

        return (DnmInvestPriceCostDO) getSqlMapClientTemplate().queryForObject("MS-DNM-INVEST-PRICE-COST-LOAD", id);

    }	