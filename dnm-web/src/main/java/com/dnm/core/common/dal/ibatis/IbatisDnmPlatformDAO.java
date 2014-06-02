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
 * find the corresponding configuration file (<tt>tables/dnm_platform.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>iwallet-dalgen</tt> 
 * to generate this file.
 *
 * @author Cheng Li
 */
	 *  Insert one <tt>DnmPlatformDO</tt> object to DB table <tt>dnm_platform</tt>, return primary key
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into dnm_platform(id,name,description,url,gmt_create,gmt_modified) values (?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param dnmPlatform
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DnmPlatformDO dnmPlatform) throws DataAccessException {
    	if (dnmPlatform == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DNM-PLATFORM-INSERT", dnmPlatform);

        return dnmPlatform.getId();
    }	
	 *  Query DB table <tt>dnm_platform</tt> for records.
	 *
   	 *  <p>
   	 *  Description for this operation is<br>
   	 *  <tt></tt>
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, name, description, url, gmt_create, gmt_modified from dnm_platform where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DnmPlatformDO
	 *	@throws DataAccessException
	 */	 
    public DnmPlatformDO load(String id) throws DataAccessException {

        return (DnmPlatformDO) getSqlMapClientTemplate().queryForObject("MS-DNM-PLATFORM-LOAD", id);

    }	