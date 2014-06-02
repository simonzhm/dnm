/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.adapter;

import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.facade.result.AccountResult;

/**
 * 平台模型适配器
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformModelAdapter.java, v 0.1 2014-5-9 上午1:29:18 hongmin.zhonghm Exp $
 */
public interface PlatformModelAdapter {

    /**
     * 填充模型
     * 
     * @param model
     * @param result
     */
    public void fillPlatformUserModel(PlatformUserModel model, AccountResult result);
}
