/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.UserModel;

/**
 * 用户领域模型服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserDomainService.java, v 0.1 2014-4-13 上午2:38:14 hongmin.zhonghm Exp $
 */
public interface UserDomainService {

    /**
     * 用户注册
     * 
     * @param userModel 用户领域模型
     */
    public void regist(UserModel userModel);

    /**
     * 登陆
     * 
     * @param userModel 用户领域模型
     */
    public void login(UserModel userModel);

}
