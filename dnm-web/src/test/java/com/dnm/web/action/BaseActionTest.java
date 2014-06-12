/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsSpringTestCase;

import com.dnm.biz.helper.AccountHelper;
import com.dnm.core.common.dal.daointerface.DnmAccountDAO;
import com.dnm.core.common.dal.daointerface.DnmBankDAO;
import com.dnm.core.common.dal.daointerface.DnmPlatformDAO;
import com.dnm.core.common.dal.daointerface.DnmUserDAO;
import com.dnm.core.common.dal.dataobject.DnmAccountDO;
import com.dnm.core.common.dal.dataobject.DnmBankDO;
import com.dnm.core.common.dal.dataobject.DnmPlatformDO;
import com.dnm.core.common.dal.dataobject.DnmUserDO;
import com.dnm.core.common.util.MD5Util;
import com.dnm.core.service.domain.convertor.AccountConvertor;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.facade.api.AccountServiceFacade;
import com.dnm.facade.api.PlatformServiceFacade;
import com.dnm.facade.constant.AccountDirectionEnum;
import com.dnm.facade.constant.AccountTypeEnum;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.constant.ThirdAccountTypeEnum;
import com.dnm.facade.request.AddPlatformUsersRequest;
import com.dnm.facade.request.PlatformUserRequest;
import com.dnm.facade.request.QueryAccountByUserIdTypeRequest;
import com.dnm.facade.result.AccountResult;

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

        Date now = new Date();

        //初始化用户
        DnmUserDAO dnmUserDAO = (DnmUserDAO) applicationContext.getBean("dnmUserDAO");
        DnmUserDO user = dnmUserDAO.load(USER_ID);
        if (user == null) {
            user = new DnmUserDO();
            user.setId(USER_ID);
            user.setUsername(MD5Util.getCode(USER_NAME));
            user.setPassword(MD5Util.getCode(USER_PWD));
            user.setEmail(USER_EMAIL);
            user.setGmtCreate(now);
            user.setGmtModified(now);
            dnmUserDAO.insert(user);
        }

        //初始化银行
        DnmBankDAO dnmBankDAO = (DnmBankDAO) applicationContext.getBean("dnmBankDAO");
        DnmBankDO bank = dnmBankDAO.load(USER_ID);
        if (bank == null) {
            bank = new DnmBankDO();
            bank.setId(USER_ID);
            bank.setBankId("CMC");
            bank.setAccountId(SRC_ACCOUNT_ID);
            bank.setBankName("招商银行深圳支行test");
            bank.setDirection(AccountDirectionEnum.DEBIT.getCode());
            bank.setUserId(USER_ID);
            bank.setGmtCreate(now);
            bank.setGmtModified(now);
            dnmBankDAO.insert(bank);
        }

        //初始化银行卡账户
        DnmAccountDAO dnmAccountDAO = (DnmAccountDAO) applicationContext.getBean("dnmAccountDAO");
        DnmAccountDO account = dnmAccountDAO.load(SRC_ACCOUNT_ID);
        if (account == null) {
            account = new DnmAccountDO();
            account.setUserId(USER_ID);
            account.setAccountId(SRC_ACCOUNT_ID);
            account.setAccountName("招商银行深圳支行test");
            account.setAccountType(AccountTypeEnum.BANK.getCode());
            account.setSubAccountType(ThirdAccountTypeEnum.CREDIT_CARD.getCode());
            account.setBalance(new BigDecimal("2000000"));
            account.setCurrency(CurrencyEnum.CNY.getCode());
            account.setDirection(AccountDirectionEnum.DEBIT.getCode());
            account.setGmtCreate(now);
            account.setGmtModified(now);
            dnmAccountDAO.insert(account);
        }

        //初始化平台
        DnmPlatformDAO dnmPlatformDAO = (DnmPlatformDAO) applicationContext
            .getBean("dnmPlatformDAO");
        DnmPlatformDO platform = dnmPlatformDAO.load(USER_ID);
        if (platform == null) {
            platform = new DnmPlatformDO();
            platform.setId(USER_ID);
            platform.setName("金豪利投资有限公司");
            platform.setDescription("携手金豪利");
            platform.setUrl("http://www.jinhaoli.net");
            platform.setGmtCreate(now);
            platform.setGmtModified(now);
            dnmPlatformDAO.insert(platform);

            //初始化平台用户
            PlatformServiceFacade platformServiceFacade = (PlatformServiceFacade) applicationContext
                .getBean("platformServiceFacade");
            AddPlatformUsersRequest addPlatformUsersRequest = new AddPlatformUsersRequest();
            addPlatformUsersRequest.setUserId(USER_ID);
            addPlatformUsersRequest.setPlatformId(USER_ID);
            PlatformUserRequest platformUserRequest = new PlatformUserRequest();
            platformUserRequest.setPlatformUserId("牛牛");
            addPlatformUsersRequest.getPlatformUsers().add(platformUserRequest);

            platformServiceFacade.addPlatformUsers(addPlatformUsersRequest);
        }

        //查找可用余额
        QueryAccountByUserIdTypeRequest queryAccountByUserIdTypeRequest = new QueryAccountByUserIdTypeRequest();
        queryAccountByUserIdTypeRequest.setUserId(USER_ID);
        queryAccountByUserIdTypeRequest.setSubAccountType("200101");
        AccountServiceFacade accountServiceFacade = (AccountServiceFacade) applicationContext
            .getBean("accountServiceFacade");
        AccountResult result = accountServiceFacade
            .queryAccountByUserIdType(queryAccountByUserIdTypeRequest);
        AccountModel accountModel = AccountHelper.convert2Model(result.getAccount());
        accountModel.setBalance(new BigDecimal("2000000"));
        accountModel.setGmtCreate(now);
        accountModel.setGmtModified(now);
        dnmAccountDAO.update(AccountConvertor.convert2DO(accountModel));

    }
}
