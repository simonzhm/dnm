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
 * find the corresponding configuration file (<tt>tables/dnm_platform_user.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmPlatformUserDO</tt> object to DB table <tt>dnm_platform_user</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_platform_user(id,user_id,platform_id,platform_user_id,total_invest_amt,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmPlatformUser
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmPlatformUserDO dnmPlatformUser) throws DataAccessException {
    	if (dnmPlatformUser == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-PLATFORM-USER-INSERT", dnmPlatformUser);

        return dnmPlatformUser.getId();
    }	
	 *  Query DB table <tt>dnm_platform_user</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_id, platform_id, platform_user_id, total_invest_amt, gmt_create, gmt_modified from dnm_platform_user where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmPlatformUserDO
	 *	@throws DataAccessException
	 */	 
    public DnmPlatformUserDO load(String id) throws DataAccessException {

        return (DnmPlatformUserDO) getSqlMapClientTemplate().queryForObject("MS-DNM-PLATFORM-USER-LOAD", id);

    }	