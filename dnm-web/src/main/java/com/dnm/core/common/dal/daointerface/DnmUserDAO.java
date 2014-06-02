/*
 * Alipay.com Inc.
 * Copyright (c) 2004 All Rights Reserved.
 */
package com.dnm.core.common.dal.daointerface;

// auto generated imports
import com.dnm.core.common.dal.dataobject.DnmUserDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>dnm_user</tt>.
 *
 * This file is generated by <tt>iwallet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dnm_user.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
public interface DnmUserDAO {
	/**
	 *  Insert one <tt>DnmUserDO</tt> object to DB table <tt>dnm_user</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_user(id,username,password,email,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmUser
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmUserDO dnmUser) throws DataAccessException;

	/**
	 *  Query DB table <tt>dnm_user</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, username, password, email, gmt_create, gmt_modified from dnm_user where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmUserDO
	 *	@throws DataAccessException
	 */	 
    public DnmUserDO load(String id) throws DataAccessException;

	/**
	 *  Query DB table <tt>dnm_user</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, username, password, email, gmt_create, gmt_modified from dnm_user where ((username = ?) AND (password = ?))</tt>
	 *
	 *	@param username
	 *	@param password
	 *	@return DnmUserDO
	 *	@throws DataAccessException
	 */	 
    public DnmUserDO loadByUsernameAndPwd(String username, String password) throws DataAccessException;

}