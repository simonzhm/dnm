/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.dal.daointerface;

import java.util.List;

import com.dnm.core.common.dal.dataobject.DnmPlatformUserAccountDO;
import com.dnm.core.common.dal.dataobject.DnmPlatformUserDO;

/**
 * ��չDAO�ӿڣ����ڶ����޷��Զ����ɵ�DAO����
 * 
 * @author hongmin.zhonghm
 * @version $Id: ExtraDao.java, v 0.1 2014-5-11 ����10:01:32 hongmin.zhonghm Exp $
 */
public interface ExtraDao {

    /**
     * �������ƽ̨�û�
     * 
     * @param platformUsers
     * @return
     */
    public Integer batchAddPlatformUsers(List<DnmPlatformUserDO> platformUsers);

    /**
     * �������ƽ̨�û��˻�
     * 
     * @param platformUserAccounts
     * @return
     */
    public Integer batchAddPlatformUserAccounts(List<DnmPlatformUserAccountDO> platformUserAccounts);
}
