/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.UserModel;

/**
 * 用户仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserRepository.java, v 0.1 2014-4-13 上午2:50:25 hongmin.zhonghm Exp $
 */
public interface UserRepository {

    /**
     * 持久化用户
     * 
     * @param userModel
     */
    public void store(UserModel userModel);

    /**
     * 根据用户名密码加载用户
     * 
     * @param userModel
     */
    public void loadByUserNameAndPwd(UserModel userModel);
}
