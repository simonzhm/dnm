/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.PlatformModel;

/**
 * 平台领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDomainService.java, v 0.1 2014-5-6 上午12:47:35 hongmin.zhonghm Exp $
 */
public interface PlatformDomainService {

    /**
     * 添加平台
     * 
     * @param model
     */
    public void addPlatform(PlatformModel model);

    /**
     * 添加平台用户
     * 
     * @param model
     */
    public void addPlatformUsers(PlatformModel model);
}
