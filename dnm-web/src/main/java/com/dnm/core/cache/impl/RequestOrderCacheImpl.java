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
 * ���󵥾���ػ���
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestOrderCache.java, v 0.1 2014-4-30 ����11:26:48 hongmin.zhonghm Exp $
 */
public class RequestOrderCacheImpl extends AbstractLocalCache implements RequestOrderCache {

    /** ���󵥾ݼ�������� */
    private Map<String, RequestChecker> checkerMap          = new HashMap<String, RequestChecker>();

    /** facade���������󵥾�ӳ�仺�� */
    private Map<Method, Class<?>>       mtdReqOrderClassMap = new HashMap<Method, Class<?>>();
    
    /** action�����󵥾��ֶ�ӳ�仺�� */
    private Map<String, Field>       actionReqOrderFieldMap = new HashMap<String, Field>();

    /** requestOrder��Ҫ����У���ע������ */
    private Map<String, List<Field>>    checkFieldMap       = new HashMap<String, List<Field>>();

    /** requestOrder��Ҫ���м��ܵ�ע������ */
    private Map<String, List<Field>>    encryptFieldMap     = new HashMap<String, List<Field>>();

    /** spring�������� */
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
            //����δ���滯���������󵥾�δ���滯������������Ȼ��Ҫ����
            synchronized (checkerMap) {
                if (checkerMap.containsKey(fullName)) {
                    return;
                } else {
                    //��ʼ�����󵥾�У����
                    initRequestChecker(requestOrderClass);

                    //��ʼ�����󵥾ݵ��ֶ�
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
                    //����ӻ�����ͨ�������ܻ�ȡ�����󵥾ݣ������󵥾���ػ���ض��Ѿ���ʼ��
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
                    //����ӻ�����ͨ�������ܻ�ȡ�����󵥾ݣ������󵥾���ػ���ض��Ѿ���ʼ��
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
     * ��ʼ�����󵥾�У����
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
            //������󵥾ݶ�Ӧ�ļ����Ϊ�գ���ȡĬ�ϼ����
            beanId = StringUtil.lowerCaseFirstChar(ReflectionUtil
                .getSimpleName(DefaultRequestChecker.class));
            obj = beanFactoryService.getBean(beanId);
        }

        AssertUtil.isTrue(obj instanceof RequestChecker, ResultCodeEnum.SYSTEM_ERROR,
            "[" + beanId + "] is not instanceof " + RequestChecker.class.getSimpleName());
        //���뻺��
        checkerMap.put(requestOrderName, (RequestChecker) obj);
    }

    /**
     * ��ʼ��ÿ��action��Ӧ���󵥾���ҪУ����ֶ�
     * 
     * @param requestOrderClass ���󵥾�����
     */
    private void initField(Class<?> requestOrderClass) {

        String requestOrderName = ReflectionUtil.getFullName(requestOrderClass);

        List<Field> fieldList = ReflectionUtil.getLoopDeclaredFields(requestOrderClass,
            BaseRequestOrder.class);

        for (Field f : fieldList) {
            //��ʼ��У���ֶ�
            initCheckField(requestOrderName, f);
            //��ʼ�������ֶ�
            initEncryptField(requestOrderName, f);

            //��������󵥾����ͣ���ݹ����
            if (ReflectionUtil.isRequestOrderField(f)) {
                initField(f.getType());
            }
            //�����List<BaseRequestOrder>
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
     * ��ʼ��У���ֶ�
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
     * ��ʼ�������ֶ�
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
