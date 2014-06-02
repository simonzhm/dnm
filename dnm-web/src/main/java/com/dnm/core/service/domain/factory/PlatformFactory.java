/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.facade.request.AddPlatformRequest;
import com.dnm.facade.request.AddPlatformUsersRequest;

/**
 * 平台领域模型工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformFactory.java, v 0.1 2014-5-5 下午11:38:07 hongmin.zhonghm Exp $
 */
public interface PlatformFactory {

    /**
     * 组装平台领域模型
     * 
     * @param requestData
     * @return
     */
    public PlatformModel compose(AddPlatformRequest requestData);

    /**
     * 组装平能用户领域模型
     * 
     * @param requestData
     * @return
     */
    public PlatformModel compose(AddPlatformUsersRequest requestData);
}
