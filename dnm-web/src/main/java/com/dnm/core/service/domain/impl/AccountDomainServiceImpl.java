/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import javax.annotation.Resource;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.AccountDomainService;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.repository.AccountRepository;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDomainServiceImpl.java, v 0.1 2014-5-6 …œŒÁ12:53:31 hongmin.zhonghm Exp $
 */
public class AccountDomainServiceImpl extends AbstractDomainService implements AccountDomainService {

    /** ’Àªß≤÷¥¢ */
    @Resource
    private AccountRepository accountRepository;

    /** 
     * @see com.dnm.core.service.domain.AccountDomainService#openAccount(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void openAccount(AccountModel model) {
        accountRepository.store(model);
    }

    /** 
     * @see com.dnm.core.service.domain.AccountDomainService#queryAccount(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void queryAccount(AccountModel model) {
        accountRepository.fill(model);
    }

    /** 
     * @see com.dnm.core.service.domain.AccountDomainService#queryAccountByUserIdType(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void queryAccountByUserIdType(AccountModel model) {
        accountRepository.reFill(model);
        AssertUtil.notBlank(model.getAccountId(), ResultCodeEnum.ACCOUNT_NOT_EXISTS,
            "userId:" + model.getUserId() + ",subAccountType:" + model.getSubAccountType());
    }

}
