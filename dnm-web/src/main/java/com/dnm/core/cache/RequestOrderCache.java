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
 * action��������ػ���
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderCache.java, v 0.1 2014-5-1 ����12:24:50 hongmin.zhonghm Exp $
 */
public interface RequestOrderCache {

    /**
     * ����actionȫ����ȡУ����
     * 
     * @param actionFullName action��ȫ����
     * @return
     */
    public RequestChecker getRequestChecker(String requestOrderName);

    /**
     * �������󵥾����ƻ�ȡУ��ע����ֶ�
     * 
     * @param requestOrderName
     * @return
     */
    public List<Field> getCheckField(String requestOrderName);

    /**
     * �������󵥾����ƻ�ȡ����ע����ֶ�
     * 
     * @param requestOrderName
     * @return
     */
    public List<Field> getEncryptField(String requestOrderName);

    /**
     * ���ݷ�����ȡ���󵥾�����
     * 
     * @param method
     * @return
     */
    public Class<?> getRequestOrderClass(Method method);

    /**
     * ������󵥾�
     * 
     * @param requestOrderClass
     */
    public void addRequestOrder(Class<?> requestOrderClass);

    /**
     * ��ӷ��������󵥾�ӳ��
     * 
     * @param method
     * @param requestOrderClass
     */
    public void addMethodRequestOrderMap(Method method, Class<?> requestOrderClass);
}
