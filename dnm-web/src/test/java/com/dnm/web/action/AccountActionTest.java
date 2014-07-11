/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dnm.facade.constant.AccountDirectionEnum;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.constant.SecondAccountTypeEnum;

/**
 * 开户测试用例
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountActionTest.java, v 0.1 2014-5-7 上午9:17:48 hongmin.zhonghm Exp $
 */
public class AccountActionTest extends BaseActionTest {

    @BeforeClass
    public static void testInit() {
        beforeTestInit();
    }

    @Test
    public void testOpenAccount() throws Exception {

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
        request.setParameter("requestData.accountName", this.getUniStr("招行"));
        request.setParameter("requestData.accountType", SecondAccountTypeEnum.CREDIT_CARD.getCode());
        request.setParameter("requestData.balance", "20000");
        request.setParameter("requestData.currency", CurrencyEnum.CNY.getCode());
        request.setParameter("requestData.direction", AccountDirectionEnum.DEBIT.getCode());
        resultStr = executeAction("/biz/openAccount");
        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", !resultStr.contains(ERROR_CODE_PREFIX));
    }

    @Test
    public void testQueryAccount() throws Exception {

        String resultStr = null;

        request.setParameter("requestData.username", USER_NAME);
        request.setParameter("requestData.password", USER_PWD);
        resultStr = executeAction("/user/login");
        LOGGER.info("test result:" + resultStr);

        request.removeAllParameters();
        request.setParameter("requestData.accountId", SRC_ACCOUNT_ID);
        resultStr = executeAction("/biz/queryAccount");
        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", !resultStr.contains(ERROR_CODE_PREFIX));
    }
}
