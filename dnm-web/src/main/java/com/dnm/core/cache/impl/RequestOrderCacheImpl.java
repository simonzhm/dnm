/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.dnm.biz.checker.DefaultRequestChecker;
import com.dnm.biz.checker.RequestChecker;
import com.dnm.core.cache.AbstractLocalCache;
import com.dnm.core.cache.RequestOrderCache;
import com.dnm.core.common.constant.CacheConstant;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.ReflectionUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.BeanFactoryService;
import com.dnm.facade.anotation.RequestFieldCheck;
import com.dnm.facade.anotation.RequestFieldEncrypt;
import com.dnm.facade.request.BaseRequestOrder;

/**
 * 请求单据相关缓存
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderCache.java, v 0.1 2014-4-30 下午11:26:48 hongmin.zhonghm Exp $
 */
public class RequestOrderCacheImpl extends AbstractLocalCache implements RequestOrderCache {

    /** 请求单据检查器缓存 */
    private Map<String, RequestChecker> checkerMap          = new HashMap<String, RequestChecker>();

    /** facade方法与请求单据映射缓存 */
    private Map<Method, Class<?>>       mtdReqOrderClassMap = new HashMap<Method, Class<?>>();
    
    /** action与请求单据字段映射缓存 */
    private Map<String, Field>       actionReqOrderFieldMap = new HashMap<String, Field>();

    /** requestOrder需要进行校验的注解属性 */
    private Map<String, List<Field>>    checkFieldMap       = new HashMap<String, List<Field>>();

    /** requestOrder需要进行加密的注解属性 */
    private Map<String, List<Field>>    encryptFieldMap     = new HashMap<String, List<Field>>();

    /** spring工厂服务 */
    @Resource
    private BeanFactoryService          beanFactoryService;

    /** 
     * @see com.dnm.core.cache.RequestOrderCache#getRequestChecker(java.lang.String)
     */
    @Override
    public RequestChecker getRequestChecker(String requestOrderName) {
        return checkerMap.get(requestOrderName);
    }

    /** 
     * @see com.dnm.core.cache.RequestOrderCache#getCheckField(java.lang.String)
     */
    @Override
    public List<Field> getCheckField(String requestOrderName) {
        return checkFieldMap.get(requestOrderName);
    }

    /** 
     * @see com.dnm.core.cache.RequestOrderCache#getEncryptField(java.lang.String)
     */
    @Override
    public List<Field> getEncryptField(String requestOrderName) {
        return encryptFieldMap.get(requestOrderName);
    }

    /** 
     * @see com.dnm.core.cache.RequestOrderCache#getRequestOrderClass(java.lang.reflect.Method)
     */
    @Override
    public Class<?> getRequestOrderClass(Method method) {
        return mtdReqOrderClassMap.get(method);
    }

    @Override
	public Field getRequestOrderField(String actionName) {
		return actionReqOrderFieldMap.get(actionName);
	}

	/** 
     * @see com.dnm.core.cache.RequestOrderCache#addRequestOrder(java.lang.Class)
     */
    @Override
    public void addRequestOrder(Class<?> requestOrderClass) {
        String fullName = ReflectionUtil.getFullName(requestOrderClass);
        RequestChecker checker = checkerMap.get(fullName);
        if (checker == null) {
            //方法未缓存化不代表请求单据未缓存化，所以这里仍然需要加锁
            synchronized (checkerMap) {
                if (checkerMap.containsKey(fullName)) {
                    return;
                } else {
                    //初始化请求单据校验器
                    initRequestChecker(requestOrderClass);

                    //初始化请求单据的字段
                    initField(requestOrderClass);
                }
            }
        }
    }

    /** 
     * @see com.dnm.core.cache.RequestOrderCache#addMethodRequestOrderMap(java.lang.reflect.Method, java.lang.Class)
     */
    @Override
    public void addMethodRequestOrderMap(Method method, Class<?> requestOrderClass) {
        Class<?> reqOrderClass = mtdReqOrderClassMap.get(method);
        if (reqOrderClass == null) {
            synchronized (mtdReqOrderClassMap) {
                reqOrderClass = mtdReqOrderClassMap.get(method);
                if (reqOrderClass != null) {
                    //如果从缓存中通过方法能获取到请求单据，则请求单据相关缓存必定已经初始化
                    return;
                } else {
                    mtdReqOrderClassMap.put(method, requestOrderClass);
                }
            }
        }
    }


	@Override
	public void addActionNameRequestOrderMap(String actionName,
			Field requestOrderField) {
		Field reqOrderField = actionReqOrderFieldMap.get(actionName);
    	if (reqOrderField == null) {
            synchronized (actionReqOrderFieldMap) {
                reqOrderField = actionReqOrderFieldMap.get(actionName);
                if (reqOrderField != null) {
                    //如果从缓存中通过方法能获取到请求单据，则请求单据相关缓存必定已经初始化
                    return;
                } else {
                	actionReqOrderFieldMap.put(actionName, requestOrderField);
                }
            }
        }
		
	}

	/** 
     * @see com.dnm.core.cache.AbstractLocalCache#doInit()
     */
    @Override
    protected void doInit() throws Exception {

        clear();
    }

    /** 
     * @see com.dnm.core.cache.DnmCache#getName()
     */
    @Override
    public String getName() {
        return CacheConstant.ACTION_CACHE;
    }

    /** 
     * @see com.dnm.core.cache.DnmCache#dump()
     */
    @Override
    public void dump() {
    }

    /**
     * 初始化请求单据校验器
     * 
     * @param field 
     * @return
     */
    private void initRequestChecker(Class<?> requestOrderClass) {
        String requestOrderName = ReflectionUtil.getFullName(requestOrderClass);

        String beanId = StringUtil.lowerCaseFirstChar(StringUtil.substringAfterLast(
            requestOrderName, ".") + "Checker");

        Object obj = null;
        try {
            obj = beanFactoryService.getBean(beanId);
        } catch (Exception e) {
            LOGGER.info("can't find bean id [" + beanId
                        + "] when init request checker, use default checker");
            //如果请求单据对应的检查器为空，则取默认检查器
            beanId = StringUtil.lowerCaseFirstChar(ReflectionUtil
                .getSimpleName(DefaultRequestChecker.class));
            obj = beanFactoryService.getBean(beanId);
        }

        AssertUtil.isTrue(obj instanceof RequestChecker, ResultCodeEnum.SYSTEM_ERROR,
            "[" + beanId + "] is not instanceof " + RequestChecker.class.getSimpleName());
        //放入缓存
        checkerMap.put(requestOrderName, (RequestChecker) obj);
    }

    /**
     * 初始化每个action对应请求单据需要校验的字段
     * 
     * @param requestOrderClass 请求单据类型
     */
    private void initField(Class<?> requestOrderClass) {

        String requestOrderName = ReflectionUtil.getFullName(requestOrderClass);

        List<Field> fieldList = ReflectionUtil.getLoopDeclaredFields(requestOrderClass,
            BaseRequestOrder.class);

        for (Field f : fieldList) {
            //初始化校验字段
            initCheckField(requestOrderName, f);
            //初始化加密字段
            initEncryptField(requestOrderName, f);

            //如果是请求单据类型，则递归添加
            if (ReflectionUtil.isRequestOrderField(f)) {
                initField(f.getType());
            }
            //如果是List<BaseRequestOrder>
            else if (ReflectionUtil.isAssignableFrom(List.class, f.getType())) {
                String genericType = f.getGenericType().toString();
                String clazzName = StringUtil.substring(genericType, genericType.indexOf("<") + 1,
                    genericType.indexOf(">"));
                Class<?> clazz = null;
                try {
                    clazz = Class.forName(clazzName);
                    if (ReflectionUtil.isAssignableFrom(BaseRequestOrder.class, clazz)) {
                        initField(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    LOGGER.error("RequestOrderCacheImpl.initField error", e);
                }
            }
        }

    }

    /**
     * 初始化校验字段
     * 
     * @param requestOrderName
     * @param f
     */
    private void initCheckField(String requestOrderName, Field f) {
        List<Field> anotationFieldList = checkFieldMap.get(requestOrderName);

        if (anotationFieldList == null) {
            anotationFieldList = new ArrayList<Field>();
            checkFieldMap.put(requestOrderName, anotationFieldList);
        }

        RequestFieldCheck rc = f.getAnnotation(RequestFieldCheck.class);
        if (rc != null) {
            anotationFieldList.add(f);
        }
    }

    /**
     * 初始化加密字段
     * 
     * @param requestOrderName
     * @param f
     */
    private void initEncryptField(String requestOrderName, Field f) {
        List<Field> anotationFieldList = encryptFieldMap.get(requestOrderName);

        if (anotationFieldList == null) {
            anotationFieldList = new ArrayList<Field>();
            encryptFieldMap.put(requestOrderName, anotationFieldList);
        }

        RequestFieldEncrypt re = f.getAnnotation(RequestFieldEncrypt.class);
        if (re != null) {
            anotationFieldList.add(f);
        }
    }

}
