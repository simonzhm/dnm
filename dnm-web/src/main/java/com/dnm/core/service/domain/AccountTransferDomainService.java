/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.AccountTransLogModel;

/**
 * 账户交易日志领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferDomainService.java, v 0.1 2014-5-6 上午12:47:35 hongmin.zhonghm Exp $
 */
public interface AccountTransferDomainService {

    /**
     * 转账，适应于账户方向都为D的
     * 
     * @param model
     */
    public void accountTransfer(AccountTransLogModel model);
}
