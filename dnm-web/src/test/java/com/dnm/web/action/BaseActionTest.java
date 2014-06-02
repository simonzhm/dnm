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
 * ���Ի���
 * @author hongmin.zhonghm
 * @version $Id: BaseActionTest.java, v 0.1 2014-4-12 ����2:27:11 hongmin.zhonghm Exp $
 */

public class BaseActionTest extends StrutsSpringTestCase {
    /** ��־ */
    protected static final Logger LOGGER            = Logger.getLogger(BaseActionTest.class);

    /** ������־ǰ׺ */
    protected static final String ERROR_CODE_PREFIX = "DNM_RS_5";

    /** ͨ���û�ID */
    protected static final String USER_ID           = "1234567890ABCDEF";

    /** ͨ���û��� */
    protected static final String USER_NAME         = "zhm_test";

    /** ͨ���û����� */
    protected static final String USER_PWD          = "zhm_test";

    /** ͨ���û����� */
    protected static final String USER_EMAIL        = "zhm_test@163.com";

    /** ͨ��Դ�˺� */
    protected static final String SRC_ACCOUNT_ID    = "1234567890ABCDEF0156";

    /** ͨ��Ŀ���˺� */
    protected static final String DEST_ACCOUNT_ID   = "FEDCBA09876543210156";

    @Override
    protected String[] getContextLocations() {
        return new String[] { "applicationContext.xml" };
    }

    /**
     * ��ȡΨһ�ֶ�
     * 
     * @param str
     * @return
     */
    protected String getUniStr(String str) {
        return str + Math.random() + System.currentTimeMillis();
    }

    public static void beforeTestInit() {
        //��ʼ���û�
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

        //��ʼ���˻�
        DnmAccountDAO dnmAccountDAO = (DnmAccountDAO) applicationContext.getBean("dnmAccountDAO");
        DnmAccountDO account = dnmAccountDAO.load(SRC_ACCOUNT_ID);
        if (account == null) {
            Date now = new Date();
            account = new DnmAccountDO();
            account.setUserId(USER_ID);
            account.setAccountId(SRC_ACCOUNT_ID);
            account.setAccountName("������������֧��test");
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
            account.setAccountName("�����Ͷ�����޹�˾test");
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
