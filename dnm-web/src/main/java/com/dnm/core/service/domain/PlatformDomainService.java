/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.PlatformModel;

/**
 * ƽ̨�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDomainService.java, v 0.1 2014-5-6 ����12:47:35 hongmin.zhonghm Exp $
 */
public interface PlatformDomainService {

    /**
     * ���ƽ̨
     * 
     * @param model
     */
    public void addPlatform(PlatformModel model);

    /**
     * ���ƽ̨�û�
     * 
     * @param model
     */
    public void addPlatformUsers(PlatformModel model);
}
