/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.adapter.spring;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.dnm.core.cache.RequestOrderCache;
import com.dnm.core.common.util.ReflectionUtil;
import com.dnm.facade.request.BaseRequestOrder;

/**
 * spring bean加载完成的后续处理
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderBeanPostProcessorImpl.java, v 0.1 2014-5-2 下午11:54:00 hongmin.zhonghm Exp $
 */
public class RequestOrderBeanPostProcessorImpl implements BeanPostProcessor {

    /** 请求单据缓存 */
    @Resource
    protected RequestOrderCache requestOrderCache;

    /** 
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
                                                                              throws BeansException {
        return bean;
    }

    /** 
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
                                                                               throws BeansException {
        //添加facade方法和单据映射缓存
        Class<?> intef = ReflectionUtil.getFacadeInterface(bean);
        if (intef != null) {
            Method[] methods = ReflectionUtil.getMethods(intef);
            for (Method method : methods) {
                Class<?>[] requestOrderClasses = method.getParameterTypes();
                if (requestOrderClasses != null && requestOrderClasses.length == 1) {
                    Class<?> requestOrderClass = requestOrderClasses[0];
                    if (ReflectionUtil.isAssignableFrom(BaseRequestOrder.class, requestOrderClass)) {
                        requestOrderCache.addMethodRequestOrderMap(method, requestOrderClass);
                        requestOrderCache.addRequestOrder(requestOrderClass);
                    }
                }
            }
        }

        return bean;
    }
}
