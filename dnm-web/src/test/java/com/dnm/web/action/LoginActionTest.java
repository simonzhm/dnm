/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.Test;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.facade.api.UserServiceFacade;
import com.dnm.facade.request.RegisterRequest;

/**
 * 登陆测试用例
 * 
 * @author hongmin.zhonghm
 * @version $Id: LoginActionTest.java, v 0.1 2014-5-4 上午12:04:39 hongmin.zhonghm Exp $
 */
public class LoginActionTest extends BaseActionTest {

    @Test
    public void testLoginError() throws Exception {
        request.setParameter("requestData.username", "xxxxxxxx");
        request.setParameter("requestData.password", "xxxxxxxx");
        String resultStr = executeAction("/user/login");

        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", resultStr.contains(ResultCodeEnum.USER_BIZ_ERROR.getCode()));
    }

    @Test
    public void testLoginSuccess() throws Exception {

        UserServiceFacade userServiceFacade = (UserServiceFacade) applicationContext
            .getBean("userServiceFacade");

        //初始化数据
        String username = this.getUniStr("zhm");
        String password = this.getUniStr("pwd");
        String email = this.getUniStr("zhm@163.com");
        RegisterRequest requestData = new RegisterRequest();
        requestData.setUsername(username);
        requestData.setPassword(password);
        requestData.setEmail(email);
        userServiceFacade.regist(requestData);

        //执行
        request.setParameter("requestData.username", username);
        request.setParameter("requestData.password", password);
        String resultStr = executeAction("/user/login");

        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", resultStr.contains(ResultCodeEnum.SUCCESS.getCode()));
    }
}
