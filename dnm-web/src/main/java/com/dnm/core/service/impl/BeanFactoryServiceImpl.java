/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

import com.dnm.core.service.BeanFactoryService;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: BeanFactoryServiceImpl.java, v 0.1 2014-5-1 ÏÂÎç8:50:47 hongmin.zhonghm Exp $
 */
public class BeanFactoryServiceImpl implements BeanFactoryService {

    /** spring bean¹¤³§ */
    private BeanFactory beanFactory;

    /** 
     * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /** 
     * @see com.dnm.core.service.BeanFactoryService#getBean(java.lang.String)
     */
    @Override
    public Object getBean(String id) {
        return beanFactory.getBean(id);
    }

}
