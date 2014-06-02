/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.adapter;

import com.dnm.core.service.domain.model.bill.AccountTransLogModel;

/**
 * 账务交易日志模型适配器
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogAdapter.java, v 0.1 2014-5-22 下午4:10:47 hongmin.zhonghm Exp $
 */
public interface AccountTransLogAdapter {

    /**
     * 填充账户模型
     * 
     * @param model
     */
    public void fillAccountModel(AccountTransLogModel model);
}
