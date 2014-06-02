/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.Test;

/**
 * ������в�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountActionTest.java, v 0.1 2014-5-7 ����9:17:48 hongmin.zhonghm Exp $
 */
public class AddPlatformActionTest extends BaseActionTest {
    @Test
    public void testExcecute() throws Exception {

        //��ʼ������
        String username = this.getUniStr("zhm");
        String password = this.getUniStr("pwd");
        String email = this.getUniStr("zhm@163.com");

        String resultStr = null;

        request.setParameter("requestData.username", username);
        request.setParameter("requestData.password", password);
        request.setParameter("requestData.email", email);
        resultStr = executeAction("/user/register");
        LOGGER.info("test result:" + resultStr);

        request.removeAllParameters();
        request.setParameter("requestData.name", this.getUniStr("�����"));
        request.setParameter("requestData.description", "Я�ֽ����");
        request.setParameter("requestData.url", "http://www.jinhaoli.com");
        resultStr = executeAction("/biz/addPlatform");
        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("���ؽ�����ɹ�", !resultStr.contains(ERROR_CODE_PREFIX));
    }
}
