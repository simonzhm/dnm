/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.BankModel;

/**
 * 银行领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankDomainService.java, v 0.1 2014-5-6 上午12:47:35 hongmin.zhonghm Exp $
 */
public interface BankDomainService {

    /**
     * 添加银行数据
     * 
     * @param model
     */
    public void addBank(BankModel model);
}
