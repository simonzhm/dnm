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
 * ƽ̨����ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformServiceFacade.java, v 0.1 2014-5-5 ����10:44:25 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface PlatformServiceFacade {

    /**
     * ���ƽ̨
     * 
     * @param requestData
     * @return 
     */
    public BaseResult addPlatform(AddPlatformRequest requestData);

    /**
     * ���ƽ̨�û�
     * 
     * @param requestData
     * @return 
     */
    public BaseResult addPlatformUsers(AddPlatformUsersRequest requestData);
}
