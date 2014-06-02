/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.dal.daointerface;

import java.util.List;

import com.dnm.core.common.dal.dataobject.DnmPlatformUserAccountDO;
import com.dnm.core.common.dal.dataobject.DnmPlatformUserDO;

/**
 * 扩展DAO接口，用于定义无法自动生成的DAO操作
 * 
 * @author hongmin.zhonghm
 * @version $Id: ExtraDao.java, v 0.1 2014-5-11 下午10:01:32 hongmin.zhonghm Exp $
 */
public interface ExtraDao {

    /**
     * 批量添加平台用户
     * 
     * @param platformUsers
     * @return
     */
    public Integer batchAddPlatformUsers(List<DnmPlatformUserDO> platformUsers);

    /**
     * 批量添加平台用户账户
     * 
     * @param platformUserAccounts
     * @return
     */
    public Integer batchAddPlatformUserAccounts(List<DnmPlatformUserAccountDO> platformUserAccounts);
}
