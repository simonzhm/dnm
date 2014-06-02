/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.Test;

import com.dnm.core.common.exception.DnmException;
import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * 用户注册测试用例
 * 
 * @author hongmin.zhonghm
 * @version $Id: RegisterActionTest.java, v 0.1 2014-4-13 下午3:00:06 hongmin.zhonghm Exp $
 */
public class RegisterActionTest extends BaseActionTest {

    @Test
    public void testExcecute() throws Exception {
        request.setParameter("requestData.username", getUniStr("zhm"));
        request.setParameter("requestData.password", "zhm123");
        request.setParameter("requestData.email", getUniStr("zhm@163.com"));
        String resultStr = executeAction("/user/register");
        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", resultStr.contains(ResultCodeEnum.SUCCESS.getCode()));
    }

    @Test
    public void testParamIllegal() throws Exception {
        request.setParameter("requestData.username", getUniStr("zhm"));
        request.setParameter("requestData.password", "zhm123");
        request.setParameter("requestData.email", getUniStr("xxx"));
        try {
            String resultStr = executeAction("/user/register");
            LOGGER.info("test result:" + resultStr);
        } catch (DnmException e) {
            Assert.assertEquals("返回结果不成功", e.getResultCode(), ResultCodeEnum.PARAM_ILLEGAL);
        }
    }
}
