/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.Test;

/**
 * 添加银行测试用例
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountActionTest.java, v 0.1 2014-5-7 上午9:17:48 hongmin.zhonghm Exp $
 */
public class AddPlatformActionTest extends BaseActionTest {
    @Test
    public void testExcecute() throws Exception {

        //初始化数据
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
        request.setParameter("requestData.name", this.getUniStr("金豪利"));
        request.setParameter("requestData.description", "携手金豪利");
        request.setParameter("requestData.url", "http://www.jinhaoli.com");
        resultStr = executeAction("/biz/addPlatform");
        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", !resultStr.contains(ERROR_CODE_PREFIX));
    }
}
