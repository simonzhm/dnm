/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * 账户领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDomainService.java, v 0.1 2014-5-6 上午12:47:35 hongmin.zhonghm Exp $
 */
public interface AccountDomainService {

    /**
     * 开户
     * 
     * @param model
     */
    public void openAccount(AccountModel model);

    /**
     * 查找账户
     * 
     * @param model
     */
    public void queryAccount(AccountModel model);
}
