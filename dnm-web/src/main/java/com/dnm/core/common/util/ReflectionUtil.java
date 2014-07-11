/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.BaseRequestOrder;

/**
 * ���乤����
 * 
 * @author hongmin.zhonghm
 * @version $Id: ReflectionUtil.java, v 0.1 2014-4-7 ����9:54:21 hongmin.zhonghm Exp $
 */
public class ReflectionUtil {

    /**
     * ��ȡ���ඨ�����������
     * 
     * @param obj
     * @return
     */
    public static List<Field> getDeclaredFields(Object obj) {

        if (obj == null) {
            return null;
        }
        return getDeclaredFields(obj.getClass());
    }

    /**
     * ��ȡ���ඨ�����������
     * 
     * @param clazz
     * @return
     */
    public static List<Field> getDeclaredFields(Class<?> clazz) {
        List<Field> fieldList = new ArrayList<Field>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            fieldList.add(field);
        }

        return fieldList;
    }

    /**
     * ���ඨ����������ԣ���������
     * 
     * @param clazz
     * @param endParentClazz �����յ㣬��������
     * @return
     */
    public static List<Field> getLoopDeclaredFields(Class<?> clazz, Class<?> endParentClazz) {
        List<Field> fieldList = new ArrayList<Field>();
        if (isAssignableFrom(endParentClazz, clazz)) {
            while (clazz != endParentClazz) {
                fieldList.addAll(getDeclaredFields(clazz));
                clazz = clazz.getSuperclass();
            }
            //������һ������
            fieldList.addAll(getDeclaredFields(clazz));
        } else {
            fieldList = getDeclaredFields(clazz);
        }

        return fieldList;
    }

    /**
     * ��ȡ�������й�������
     * 
     * @param obj
     * @return
     */
    public static Method[] getMethods(Object obj) {
        return getMethods(obj.getClass());
    }

    /**
     * ��ȡ�������й�������
     * 
     * @param obj
     * @return
     */
    public static Method[] getMethods(Class<?> clazz) {
        if (clazz == null)
            return null;
        return clazz.getMethods();
    }

    /**
     * ��ȡ����ļ�����
     * 
     * @param obj
     * @return
     */
    public static String getSimpleName(Object obj) {
        return getSimpleName(obj.getClass());
    }

    /**
     * ��ȡ����ļ�����
     * 
     * @param obj
     * @return
     */
    public static String getSimpleName(Class<?> clazz) {
        return clazz == null ? null : clazz.getSimpleName();
    }

    /**
     * ��ȡ�����ȫ����
     * 
     * @param obj
     * @return
     */
    public static String getFullName(Object obj) {
        return getFullName(obj.getClass());
    }

    /**
     * ��ȡ�����ȫ����
     * 
     * @param obj
     * @return
     */
    public static String getFullName(Class<?> clazz) {
        return clazz == null ? null : clazz.getName();
    }

    /**
     * �Ƿ������󵥾�
     * 
     * @param f
     * @return
     */
    public static boolean isRequestOrderField(Field f) {
        return isAssignableFrom(BaseRequestOrder.class, f.getType());
    }

    /**
     * �Ƿ�������
     * 
     * @param parent
     * @param child
     * @return
     */
    public static boolean isAssignableFrom(Class<?> parent, Class<?> child) {
        return parent.isAssignableFrom(child);
    }

    /**
     * �Ƿ���facade�ӿ�
     * 
     * @param bean
     * @return
     */
    public static Class<?> getFacadeInterface(Object bean) {
        Class<?>[] interfaces = bean.getClass().getInterfaces();
        for (Class<?> intef : interfaces) {
            if (intef.getAnnotation(FacadeApi.class) != null) {
                return intef;
            }
        }
        return null;
    }
    
    /**
     * ��ȡ���е�requestOrder����
     * @param bean
     * @return
     */
    public static Field getRequestOrderField(Object bean){
    	List<Field> fields = getDeclaredFields(bean.getClass());
    	for(Field field : fields){
    		if(isRequestOrderField(field)){
    			return field;
    		}
    	}
    	return null;
    }
    
    /**
     * ��ȡ����ֵ
     * @param bean
     * @param field
     * @return
     */
    public static Object getFieldValue(Object bean, Field field){
    	field.setAccessible(true);
    	Object value = null;
    	try {
			value = field.get(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return value;
    }
}
