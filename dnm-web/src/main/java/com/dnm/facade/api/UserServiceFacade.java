/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.LoginRequest;
import com.dnm.facade.request.RegisterRequest;
import com.dnm.facade.result.LoginResult;
import com.dnm.facade.result.RegisterResult;

/**
 * 用户服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserServiceFacade.java, v 0.1 2014-5-2 下午5:01:01 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface UserServiceFacade {

    /**
     * 注册
     * 
     * @param requestData
     * @return
     */
    public RegisterResult regist(RegisterRequest requestData);

    /**
     * 登陆
     * 
     * @param requestData
     * @return
     */
    public LoginResult login(LoginRequest requestData);

}
