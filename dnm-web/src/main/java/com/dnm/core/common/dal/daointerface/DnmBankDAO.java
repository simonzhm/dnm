/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.daointerface;

// auto generated imports
import com.dnm.core.common.dal.dataobject.DnmBankDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>dnm_bank</tt>.
 *
 * This file is generated by <tt>iwallet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dnm_bank.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
public interface DnmBankDAO {
	/**
	 *  Insert one <tt>DnmBankDO</tt> object to DB table <tt>dnm_bank</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_bank(id,user_id,bank_id,bank_name,direction,account_id,bill_date,repay_date,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmBank
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmBankDO dnmBank) throws DataAccessException;

	/**
	 *  Query DB table <tt>dnm_bank</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, bank_id, bank_name, direction, account_id, bill_date, repay_date, gmt_create, gmt_modified from dnm_account where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmBankDO
	 *	@throws DataAccessException
	 */	 
    public DnmBankDO load(String id) throws DataAccessException;

}