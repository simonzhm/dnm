/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.Test;

import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * ��½��������
 * 
 * @author hongmin.zhonghm
 * @version $Id: LoginActionTest.java, v 0.1 2014-5-4 ����12:04:39 hongmin.zhonghm Exp $
 */
public class LoginActionTest extends BaseActionTest {

    @Test
    public void testLoginError() throws Exception {
        request.setParameter("requestData.username", "xxxxxxxx");
        request.setParameter("requestData.password", "xxxxxxxx");
        String resultStr = executeAction("/user/login");

        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("���ؽ�����ɹ�", resultStr.contains(ResultCodeEnum.USER_BIZ_ERROR.getCode()));
    }

    @Test
    public void testLoginSuccess() throws Exception {

        //ִ��
        request.setParameter("requestData.username", USER_NAME);
        request.setParameter("requestData.password", USER_PWD);
        String resultStr = executeAction("/user/login");

        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("���ؽ�����ɹ�", resultStr.contains(ResultCodeEnum.SUCCESS.getCode()));
    }
}
