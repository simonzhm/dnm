/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.facade.request.LoginRequest;
import com.dnm.facade.request.RegisterRequest;

/**
 * 用户领域模型工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserFactory.java, v 0.1 2014-4-13 下午2:26:52 hongmin.zhonghm Exp $
 */
public interface UserFactory {

    /**
     * 根据注册信息组装用户基本模型
     * 
     * @param requestData
     * @return
     */
    public UserModel compose(RegisterRequest requestData);

    /**
     * 根据登陆信息组装用户基本模型
     * 
     * @param requestData
     * @return
     */
    public UserModel compose(LoginRequest requestData);
}
