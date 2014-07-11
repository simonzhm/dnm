/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.service.SequenceService;
import com.dnm.facade.constant.SubTransCodeEnum;
import com.dnm.facade.constant.TransCodeEnum;

/**
 * 账户交易测试用例
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferActionTest.java, v 0.1 2014-5-7 上午9:17:48 hongmin.zhonghm Exp $
 */
public class AccountTransferActionTest extends BaseActionTest {

    @BeforeClass
    public static void testInit() {
        beforeTestInit();
    }

    @Test
    public void testTransfer() throws Exception {
        SequenceService sequenceService = (SequenceService) applicationContext
            .getBean("sequenceService");

        String resultStr = null;
        request.setParameter("requestData.username", USER_NAME);
        request.setParameter("requestData.password", USER_PWD);
        resultStr = executeAction("/user/login");
        LOGGER.info("test result:" + resultStr);

        request.removeAllParameters();
        String bizId = DBKeyUtil.complete16(new Date(), sequenceService.getDnmAccountLogSeq());
        request.setParameter("requestData.guid", bizId);
        request.setParameter("requestData.bizId", bizId);
        request.setParameter("requestData.transCode", TransCodeEnum.DEPOSIT.getCode());
        request
            .setParameter("requestData.transSubCode", SubTransCodeEnum.OFFLINE_DEPOSIT.getCode());
        request.setParameter("requestData.transAmt", "180");
        request.setParameter("requestData.transCurrency", "CNY");
        request.setParameter("requestData.transTime", "2014-05-15 11:11:11");
        request.setParameter("requestData.debitAccount", SRC_ACCOUNT_ID);
        request.setParameter("requestData.creditAccount", DEST_ACCOUNT_ID);
        request.setParameter("requestData.memo", "测试");
        resultStr = executeAction("/biz/accountTransfer");
        LOGGER.info("test result:" + resultStr);

        Assert.assertTrue("返回结果不成功", !resultStr.contains(ERROR_CODE_PREFIX));
    }
}
