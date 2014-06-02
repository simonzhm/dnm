/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.AddPlatformRequest;
import com.dnm.facade.request.AddPlatformUsersRequest;
import com.dnm.facade.result.BaseResult;

/**
 * 平台服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformServiceFacade.java, v 0.1 2014-5-5 上午10:44:25 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface PlatformServiceFacade {

    /**
     * 添加平台
     * 
     * @param requestData
     * @return 
     */
    public BaseResult addPlatform(AddPlatformRequest requestData);

    /**
     * 添加平台用户
     * 
     * @param requestData
     * @return 
     */
    public BaseResult addPlatformUsers(AddPlatformUsersRequest requestData);
}
