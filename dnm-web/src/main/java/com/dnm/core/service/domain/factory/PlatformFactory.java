/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.facade.request.AddPlatformRequest;
import com.dnm.facade.request.AddPlatformUsersRequest;

/**
 * ƽ̨����ģ�͹���
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformFactory.java, v 0.1 2014-5-5 ����11:38:07 hongmin.zhonghm Exp $
 */
public interface PlatformFactory {

    /**
     * ��װƽ̨����ģ��
     * 
     * @param requestData
     * @return
     */
    public PlatformModel compose(AddPlatformRequest requestData);

    /**
     * ��װƽ���û�����ģ��
     * 
     * @param requestData
     * @return
     */
    public PlatformModel compose(AddPlatformUsersRequest requestData);
}
