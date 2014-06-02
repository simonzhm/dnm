/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.BankModel;

/**
 * 银行仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankRepository.java, v 0.1 2014-5-6 下午11:53:20 hongmin.zhonghm Exp $
 */
public interface BankRepository {

    /**
     * 持久化银行数据
     * 
     * @param model
     */
    public void store(BankModel model);
}
