/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.PlatformModel;

/**
 * ƽ̨�ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformRepository.java, v 0.1 2014-5-10 ����1:49:23 hongmin.zhonghm Exp $
 */
public interface PlatformRepository {

    /**
     * �־û�ƽ̨
     * 
     * @param model
     */
    public void store(PlatformModel model);

}
