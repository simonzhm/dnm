/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.dnm.biz.checker.RequestChecker;

/**
 * action处理类相关缓存
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderCache.java, v 0.1 2014-5-1 上午12:24:50 hongmin.zhonghm Exp $
 */
public interface RequestOrderCache {

    /**
     * 根据action全名获取校验器
     * 
     * @param actionFullName action的全包名
     * @return
     */
    public RequestChecker getRequestChecker(String requestOrderName);

    /**
     * 根据请求单据名称获取校验注解的字段
     * 
     * @param requestOrderName
     * @return
     */
    public List<Field> getCheckField(String requestOrderName);

    /**
     * 根据请求单据名称获取加密注解的字段
     * 
     * @param requestOrderName
     * @return
     */
    public List<Field> getEncryptField(String requestOrderName);

    /**
     * 根据方法获取请求单据类型
     * 
     * @param method
     * @return
     */
    public Class<?> getRequestOrderClass(Method method);

    /**
     * 添加请求单据
     * 
     * @param requestOrderClass
     */
    public void addRequestOrder(Class<?> requestOrderClass);

    /**
     * 添加方法和请求单据映射
     * 
     * @param method
     * @param requestOrderClass
     */
    public void addMethodRequestOrderMap(Method method, Class<?> requestOrderClass);
}
