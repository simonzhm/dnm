/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.aop.MethodBeforeAdvice;

import com.dnm.biz.checker.RequestChecker;
import com.dnm.biz.encrypter.Encrypter;
import com.dnm.biz.encrypter.EncrypterFactory;
import com.dnm.core.cache.RequestOrderCache;
import com.dnm.core.common.util.ReflectionUtil;
import com.dnm.facade.anotation.RequestFieldEncrypt;
import com.dnm.facade.request.BaseRequestOrder;

/**
 * �������У��������
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderAdvice.java, v 0.1 2014-4-29 ����9:04:51 hongmin.zhonghm Exp $
 */
public class RequestOrderAdvice implements MethodBeforeAdvice {

    /** ���󵥾ݻ��� */
    @Resource
    protected RequestOrderCache requestOrderCache;

    /** ���������� */
    @Resource
    private EncrypterFactory    encrypterFactory;

    /** 
     * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
     */
    @Override
    public void before(Method method, Object[] parameters, Object bean) throws Throwable {
        if (requestOrderCache.getRequestOrderClass(method) != null) {
            process((BaseRequestOrder) parameters[0]);
        }
    }

    /**
     * ��ȡ���󵥾�У����
     * 
     * @param requestOrder 
     * @return
     */
    private void process(BaseRequestOrder requestOrder) throws Throwable {
        check(requestOrder);
        encrypt(requestOrder);
    }

    /**
     * �ֶ�У��
     * 
     * @param requestOrder
     */
    private void check(BaseRequestOrder requestOrder) throws Throwable {
        String fullName = ReflectionUtil.getFullName(requestOrder);
        RequestChecker checker = requestOrderCache.getRequestChecker(fullName);
        checker.check(requestOrder);
    }

    /**
     * �ֶμ���
     * 
     * @param requestOrder
     */
    private void encrypt(BaseRequestOrder requestOrder) throws Throwable {
        String fullName = ReflectionUtil.getFullName(requestOrder);
        List<Field> fields = requestOrderCache.getEncryptField(fullName);
        RequestFieldEncrypt re = null;
        Encrypter encrypter = null;
        String encryptValue = null;
        for (Field f : fields) {
            re = f.getAnnotation(RequestFieldEncrypt.class);
            encrypter = encrypterFactory.getEncrypter(re.format());
            encryptValue = encrypter.encrypt(f.get(requestOrder).toString());
            f.setAccessible(true);
            f.set(requestOrder, encryptValue);
        }
    }
}
