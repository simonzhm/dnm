/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service;

import org.springframework.beans.factory.BeanFactoryAware;

/**
 * spring��������
 * @author hongmin.zhonghm
 * @version $Id: BeanFactoryService.java, v 0.1 2014-5-1 ����8:49:25 hongmin.zhonghm Exp $
 */
public interface BeanFactoryService extends BeanFactoryAware {

    /**
     * ��ȡspring�����еĶ���
     * 
     * @param id
     * @return
     */
    public Object getBean(String id);

}
