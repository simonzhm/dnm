/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.util.Collection;

import org.springframework.util.CollectionUtils;

import com.dnm.core.common.exception.DnmException;
import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * 断言工具类
 * 
 * @author hongmin.zhonghm
 * @version $Id: AssertUtil.java, v 0.1 2014-4-7 下午8:44:40 hongmin.zhonghm Exp $
 */
public class AssertUtil {
    /**
     * 私有构造方法，避免实例化
     */
    private AssertUtil() {

    }

    /**
     * 断言对象是否为空，为空抛出参数非法异常。
     * 
     * @param obj 待测对象
     * @param ResultCodeEnum 校验不过抛出异常的异常码
     * @param msg 异常消息
     * @throws DnmException 对象为空异常
     */
    public static void notNull(Object obj, ResultCodeEnum code, String msg) throws DnmException {
        if (obj == null) {
            throwDnmException(code, msg);
        }
    }

    /**
     * 断言字符串是否为空，如果为空抛出异常。
     * 
     * @param str 待测字符串
     * @param ResultCodeEnum 校验不过抛出异常的异常码
     * @param msg 异常消息
     * @throws DnmException
     */
    public static void notBlank(String str, ResultCodeEnum code, String msg) throws DnmException {
        if (StringUtil.isBlank(str)) {
            throwDnmException(code, msg);
        }
    }

    /**
     * 集合是否为空，如果为空抛出异常。
     * 
     * @param collection 集合
     * @param ResultCodeEnum 校验不过抛出异常的异常码
     * @param msg 异常消息
     * @throws DnmException
     */
    public static void notEmpty(Collection<?> collection, ResultCodeEnum code, String msg)
                                                                                          throws DnmException {
        if (CollectionUtils.isEmpty(collection)) {
            throwDnmException(code, msg);
        }
    }

    /**
     * 断言是否为<code>true</code>，如果不是抛出异常。
     * 
     * @param expected 待测值
     * @param code 异常码
     * @param msg 异常消息
     * @throws DnmException
     */
    public static void isTrue(boolean expected, ResultCodeEnum code, String msg)
                                                                                throws DnmException {
        if (!expected) {
            throwDnmException(code, msg);
        }
    }

    /**
     * 断言是否为<code>false</code>，如果不是抛出异常。
     * 
     * @param expected 待测值
     * @param code 异常码
     * @param msg 异常消息
     * @throws DnmException
     */
    public static void isFalse(boolean expected, ResultCodeEnum code, String msg)
                                                                                 throws DnmException {
        if (expected) {
            throwDnmException(code, msg);
        }
    }

    /**
     * 比较两个对象是否相等，不相等抛出异常。两个对象都为null也表示相等
     * 
     * @param origin    原对象
     * @param target    目标对象
     * @param code      比较失败异常码
     * @param msg       比较失败消息
     * 
     * @throws DnmException
     */
    public static void equals(Object origin, Object target, ResultCodeEnum code, String msg)
                                                                                            throws DnmException {
        // 相等直接返回
        if (origin == target) {
            return;
        }

        // 其中一个为null或者不相等抛出异常
        if (origin == null || target == null || !origin.equals(target)) {
            throwDnmException(code, msg);
        }
    }

    /**
     * 创建拒付异常并抛出
     * 
     * @param code 异常码
     * @param msg 异常描述
     * @throws DnmException
     */
    public static void throwDnmException(ResultCodeEnum code, String msg) throws DnmException {
        throw new DnmException(code, msg);
    }
}
