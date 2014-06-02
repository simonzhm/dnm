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
 * 请求参数校验拦截器
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderAdvice.java, v 0.1 2014-4-29 上午9:04:51 hongmin.zhonghm Exp $
 */
public class RequestOrderAdvice implements MethodBeforeAdvice {

    /** 请求单据缓存 */
    @Resource
    protected RequestOrderCache requestOrderCache;

    /** 加密器工厂 */
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
     * 获取请求单据校验器
     * 
     * @param requestOrder 
     * @return
     */
    private void process(BaseRequestOrder requestOrder) throws Throwable {
        check(requestOrder);
        encrypt(requestOrder);
    }

    /**
     * 字段校验
     * 
     * @param requestOrder
     */
    private void check(BaseRequestOrder requestOrder) throws Throwable {
        String fullName = ReflectionUtil.getFullName(requestOrder);
        RequestChecker checker = requestOrderCache.getRequestChecker(fullName);
        checker.check(requestOrder);
    }

    /**
     * 字段加密
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
