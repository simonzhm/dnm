/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.AccountService;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.repository.AccountRepository;

/**
 * 账户内部服务接口实现
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountServiceImpl.java, v 0.1 2014-5-22 上午11:39:34 hongmin.zhonghm Exp $
 */
public class AccountServiceImpl implements AccountService {

    /** 账户仓储 */
    @Resource
    private AccountRepository accountRepository;

    /** 
     * @see com.dnm.core.service.AccountService#lockTransferAccounts(java.lang.String, java.lang.String)
     */
    @Override
    public List<AccountModel> lockTransferAccounts(String debitAccountId, String creditAccountId) {
        List<AccountModel> accountModels = new ArrayList<AccountModel>();
        AccountModel inAccountModel = new AccountModel();
        AccountModel outAccountModel = new AccountModel();

        if (debitAccountId.compareTo(creditAccountId) < 0) {
            inAccountModel.setAccountId(debitAccountId);
            accountRepository.active(inAccountModel);

            outAccountModel.setAccountId(creditAccountId);
            accountRepository.active(outAccountModel);
        } else {
            outAccountModel.setAccountId(creditAccountId);
            accountRepository.active(outAccountModel);

            inAccountModel.setAccountId(debitAccountId);
            accountRepository.active(inAccountModel);
        }

        AssertUtil.notBlank(inAccountModel.getAccountType(), ResultCodeEnum.ACCOUNT_NOT_EXISTS,
            "accountId:" + debitAccountId);
        AssertUtil.notBlank(outAccountModel.getAccountType(), ResultCodeEnum.ACCOUNT_NOT_EXISTS,
            "accountId:" + creditAccountId);

        accountModels.add(inAccountModel);
        accountModels.add(outAccountModel);
        return accountModels;
    }
}
