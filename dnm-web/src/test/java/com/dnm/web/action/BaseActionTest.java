/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsSpringTestCase;

import com.dnm.core.common.dal.daointerface.DnmAccountDAO;
import com.dnm.core.common.dal.daointerface.DnmUserDAO;
import com.dnm.core.common.dal.dataobject.DnmAccountDO;
import com.dnm.core.common.dal.dataobject.DnmUserDO;
import com.dnm.core.common.util.MD5Util;
import com.dnm.facade.constant.AccountDirectionEnum;
import com.dnm.facade.constant.AccountTypeEnum;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.constant.SubAccountTypeEnum;

/**
 * 测试基类
 * @author hongmin.zhonghm
 * @version $Id: BaseActionTest.java, v 0.1 2014-4-12 下午2:27:11 hongmin.zhonghm Exp $
 */

public class BaseActionTest extends StrutsSpringTestCase {
    /** 日志 */
    protected static final Logger LOGGER            = Logger.getLogger(BaseActionTest.class);

    /** 错误日志前缀 */
    protected static final String ERROR_CODE_PREFIX = "DNM_RS_5";

    /** 通用用户ID */
    protected static final String USER_ID           = "1234567890ABCDEF";

    /** 通用用户名 */
    protected static final String USER_NAME         = "zhm_test";

    /** 通用用户密码 */
    protected static final String USER_PWD          = "zhm_test";

    /** 通用用户邮箱 */
    protected static final String USER_EMAIL        = "zhm_test@163.com";

    /** 通用源账号 */
    protected static final String SRC_ACCOUNT_ID    = "1234567890ABCDEF0156";

    /** 通用目标账号 */
    protected static final String DEST_ACCOUNT_ID   = "FEDCBA09876543210156";

    @Override
    protected String[] getContextLocations() {
        return new String[] { "applicationContext.xml" };
    }

    /**
     * 获取唯一字段
     * 
     * @param str
     * @return
     */
    protected String getUniStr(String str) {
        return str + Math.random() + System.currentTimeMillis();
    }

    public static void beforeTestInit() {
        //初始化用户
        DnmUserDAO dnmUserDAO = (DnmUserDAO) applicationContext.getBean("dnmUserDAO");
        DnmUserDO user = dnmUserDAO.load(USER_ID);
        if (user == null) {
            Date now = new Date();
            user = new DnmUserDO();
            user.setId(USER_ID);
            user.setUsername(MD5Util.getCode(USER_NAME));
            user.setPassword(MD5Util.getCode(USER_PWD));
            user.setEmail(USER_EMAIL);
            user.setGmtCreate(now);
            user.setGmtModified(now);
            dnmUserDAO.insert(user);
        }

        //初始化账户
        DnmAccountDAO dnmAccountDAO = (DnmAccountDAO) applicationContext.getBean("dnmAccountDAO");
        DnmAccountDO account = dnmAccountDAO.load(SRC_ACCOUNT_ID);
        if (account == null) {
            Date now = new Date();
            account = new DnmAccountDO();
            account.setUserId(USER_ID);
            account.setAccountId(SRC_ACCOUNT_ID);
            account.setAccountName("招商银行深圳支行test");
            account.setAccountType(AccountTypeEnum.BANK.getCode());
            account.setSubAccountType(SubAccountTypeEnum.CREDIT_CARD.getCode());
            account.setBalance(new BigDecimal("2000"));
            account.setCurrency(CurrencyEnum.CNY.getCode());
            account.setDirection(AccountDirectionEnum.DEBIT.getCode());
            account.setGmtCreate(now);
            account.setGmtModified(now);
            dnmAccountDAO.insert(account);
        }

        account = dnmAccountDAO.load(DEST_ACCOUNT_ID);
        if (account == null) {
            Date now = new Date();
            account = new DnmAccountDO();
            account.setUserId(USER_ID);
            account.setAccountId(DEST_ACCOUNT_ID);
            account.setAccountName("金豪利投资有限公司test");
            account.setAccountType(AccountTypeEnum.PLATFORM.getCode());
            account.setSubAccountType(SubAccountTypeEnum.PLATFORM_BALANCE.getCode());
            account.setBalance(new BigDecimal("2000"));
            account.setCurrency(CurrencyEnum.CNY.getCode());
            account.setDirection(AccountDirectionEnum.DEBIT.getCode());
            account.setGmtCreate(now);
            account.setGmtModified(now);
            dnmAccountDAO.insert(account);
        }
    }
}
