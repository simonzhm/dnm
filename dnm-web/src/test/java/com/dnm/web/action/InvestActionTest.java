/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dnm.facade.constant.InterestRateTypeEnum;
import com.dnm.facade.constant.PeriodTypeEnum;
import com.dnm.facade.constant.RepayMethodEnum;
import com.dnm.facade.constant.SubTransCodeEnum;

/**
 * 投标测试类
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestActionTest.java, v 0.1 2014-4-11 上午1:54:26 hongmin.zhonghm Exp $
 */
public class InvestActionTest extends BaseActionTest {

    @BeforeClass
    public static void testInit() {
        beforeTestInit();
    }

    @Test
    public void testInvest() throws Exception {
        String resultStr = null;
        request.setParameter("requestData.username", USER_NAME);
        request.setParameter("requestData.password", USER_PWD);
        resultStr = executeAction("/user/login");
        LOGGER.info("test result:" + resultStr);

        request.removeAllParameters();

        request.setParameter("requestData.platformUserId", "牛牛");
        request.setParameter("requestData.period", "3");
        request.setParameter("requestData.periodType", PeriodTypeEnum.MONTH.getCode());
        request.setParameter("requestData.repaymentMethod",
            RepayMethodEnum.MONTH_INTEREST.getCode());
        request.setParameter("requestData.investAmt", "10000");
        request.setParameter("requestData.investDate", "20140610");
        request.setParameter("requestData.interestRate", "21.6");
        request.setParameter("requestData.interestRateType", InterestRateTypeEnum.YEAR.getCode());
        request.setParameter("requestData.feeRate", "5");
        request.setParameter("requestData.investPriceList[0].type",
            SubTransCodeEnum.RE_INVEST_PRICE.getCode());
        request.setParameter("requestData.investPriceList[0].origAmt", "2000");
        request.setParameter("requestData.investPriceList[0].rate", "0.1");
        request.setParameter("requestData.investPriceList[0].isFinish", "Y");
        request.setParameter("requestData.investPriceList[1].type",
            SubTransCodeEnum.RE_INVEST_PRICE.getCode());
        request.setParameter("requestData.investPriceList[1].origAmt", "10000");
        request.setParameter("requestData.investPriceList[1].rate", "1.2");
        request.setParameter("requestData.investPriceList[1].isFinish", "Y");

        request.setParameter("requestData.fromAccountList[0].accountId", "1234567890ABCDEF0156");
        request.setParameter("requestData.fromAccountList[0].amount", "10000");
        request.setParameter("requestData.isFinish", "N");
        resultStr = executeAction("/biz/invest");

        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", !resultStr.contains(ERROR_CODE_PREFIX));
    }
}
