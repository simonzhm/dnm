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
 * 反射工具类
 * 
 * @author hongmin.zhonghm
 * @version $Id: ReflectionUtil.java, v 0.1 2014-4-7 下午9:54:21 hongmin.zhonghm Exp $
 */
public class ReflectionUtil {

    /**
     * 获取本类定义的所有属性
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
     * 获取本类定义的所有属性
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
     * 获类定义的所有属性，包括父类
     * 
     * @param clazz
     * @param endParentClazz 父类终点，包括本类
     * @return
     */
    public static List<Field> getLoopDeclaredFields(Class<?> clazz, Class<?> endParentClazz) {
        List<Field> fieldList = new ArrayList<Field>();
        if (isAssignableFrom(endParentClazz, clazz)) {
            while (clazz != endParentClazz) {
                fieldList.addAll(getDeclaredFields(clazz));
                clazz = clazz.getSuperclass();
            }
            //添加最后一个父类
            fieldList.addAll(getDeclaredFields(clazz));
        } else {
            fieldList = getDeclaredFields(clazz);
        }

        return fieldList;
    }

    /**
     * 获取对象所有公共方法
     * 
     * @param obj
     * @return
     */
    public static Method[] getMethods(Object obj) {
        return getMethods(obj.getClass());
    }

    /**
     * 获取对象所有公共方法
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
     * 获取对象的简单类名
     * 
     * @param obj
     * @return
     */
    public static String getSimpleName(Object obj) {
        return getSimpleName(obj.getClass());
    }

    /**
     * 获取对象的简单类名
     * 
     * @param obj
     * @return
     */
    public static String getSimpleName(Class<?> clazz) {
        return clazz == null ? null : clazz.getSimpleName();
    }

    /**
     * 获取对象的全类名
     * 
     * @param obj
     * @return
     */
    public static String getFullName(Object obj) {
        return getFullName(obj.getClass());
    }

    /**
     * 获取对象的全类名
     * 
     * @param obj
     * @return
     */
    public static String getFullName(Class<?> clazz) {
        return clazz == null ? null : clazz.getName();
    }

    /**
     * 是否是请求单据
     * 
     * @param f
     * @return
     */
    public static boolean isRequestOrderField(Field f) {
        return isAssignableFrom(BaseRequestOrder.class, f.getType());
    }

    /**
     * 是否是子类
     * 
     * @param parent
     * @param child
     * @return
     */
    public static boolean isAssignableFrom(Class<?> parent, Class<?> child) {
        return parent.isAssignableFrom(child);
    }

    /**
     * 是否是facade接口
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
     * 获取类中的requestOrder属性
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
     * 获取属性值
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
