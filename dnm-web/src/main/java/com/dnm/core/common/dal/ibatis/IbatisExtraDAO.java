/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.dal.ibatis;

import java.util.List;

import com.dnm.core.common.dal.daointerface.ExtraDao;
import com.dnm.core.common.dal.dataobject.DnmPlatformUserAccountDO;
import com.dnm.core.common.dal.dataobject.DnmPlatformUserDO;
import com.dnm.core.common.dal.ibatis.support.BatchSqlMapClientDaoSupport;

/**
 * 扩展DAO实现，用于定义无法自动生成的DAO操作
 * 
 * @author hongmin.zhonghm
 * @version $Id: IbatisExtraDAO.java, v 0.1 2014-5-11 下午10:38:37 hongmin.zhonghm Exp $
 */
public class IbatisExtraDAO extends BatchSqlMapClientDaoSupport implements ExtraDao {

    /** 
     * @see com.dnm.core.common.dal.daointerface.ExtraDao#batchAddPlatformUsers(java.util.List)
     */
    @Override
    public Integer batchAddPlatformUsers(List<DnmPlatformUserDO> platformUsers) {
        return this.batchInsert("MS-DNM-PLATFORM-USER-INSERT", platformUsers);
    }

    /** 
     * @see com.dnm.core.common.dal.daointerface.ExtraDao#batchAddPlatformUserAccounts(java.util.List)
     */
    @Override
    public Integer batchAddPlatformUserAccounts(List<DnmPlatformUserAccountDO> platformUserAccounts) {
        return this.batchInsert("MS-DNM-PLATFORM-USER-ACCOUNT-INSERT", platformUserAccounts);
    }

}
