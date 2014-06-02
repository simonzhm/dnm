/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service;

import org.springframework.beans.factory.BeanFactoryAware;

/**
 * spring工厂服务
 * @author hongmin.zhonghm
 * @version $Id: BeanFactoryService.java, v 0.1 2014-5-1 下午8:49:25 hongmin.zhonghm Exp $
 */
public interface BeanFactoryService extends BeanFactoryAware {

    /**
     * 获取spring容器中的对象
     * 
     * @param id
     * @return
     */
    public Object getBean(String id);

}
