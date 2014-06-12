/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * 账户仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountRepository.java, v 0.1 2014-5-6 下午11:53:20 hongmin.zhonghm Exp $
 */
public interface AccountRepository {

    /**
     * 持久化账户
     * 
     * @param model
     */
    public void store(AccountModel model);

    /**
     * 主键加载并填充模型
     * 
     * @param model
     */
    public void fill(AccountModel model);

    /**
     * 非主键加载并填充模型
     * 
     * @param model
     */
    public void reFill(AccountModel model);

    /**
     * 加载并填充模型（加锁）
     * 
     * @param model
     */
    public void active(AccountModel model);
}
