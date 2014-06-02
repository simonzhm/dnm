/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.PlatformModel;

/**
 * 平台仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformRepository.java, v 0.1 2014-5-10 下午1:49:23 hongmin.zhonghm Exp $
 */
public interface PlatformRepository {

    /**
     * 持久化平台
     * 
     * @param model
     */
    public void store(PlatformModel model);

}
