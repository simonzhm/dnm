/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.AccountTransLogModel;

/**
 * 账户交易日志仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountRepository.java, v 0.1 2014-5-6 下午11:53:20 hongmin.zhonghm Exp $
 */
public interface AccountTransLogRepository {

    /**
     * 持久化账户交易日志
     * 
     * @param model
     */
    public void store(AccountTransLogModel model);
}
