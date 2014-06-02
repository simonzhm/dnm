/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service;

import java.util.List;

import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * 账户内部服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountService.java, v 0.1 2014-5-22 上午11:30:46 hongmin.zhonghm Exp $
 */
public interface AccountService {

    /**
     * 获取交易账户，获取顺序按账户ID从小到大排序，防止死锁
     * 
     * @param accountId
     * @return 两个账户，第一个为入款账户，第二个为出款账户
     */
    public List<AccountModel> lockTransferAccounts(String inAccountId, String outAccountId);
}
