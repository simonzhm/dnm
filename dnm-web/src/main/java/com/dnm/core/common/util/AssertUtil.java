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
 * ���Թ�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: AssertUtil.java, v 0.1 2014-4-7 ����8:44:40 hongmin.zhonghm Exp $
 */
public class AssertUtil {
    /**
     * ˽�й��췽��������ʵ����
     */
    private AssertUtil() {

    }

    /**
     * ���Զ����Ƿ�Ϊ�գ�Ϊ���׳������Ƿ��쳣��
     * 
     * @param obj �������
     * @param ResultCodeEnum У�鲻���׳��쳣���쳣��
     * @param msg �쳣��Ϣ
     * @throws DnmException ����Ϊ���쳣
     */
    public static void notNull(Object obj, ResultCodeEnum code, String msg) throws DnmException {
        if (obj == null) {
            throwDnmException(code, msg);
        }
    }

    /**
     * �����ַ����Ƿ�Ϊ�գ����Ϊ���׳��쳣��
     * 
     * @param str �����ַ���
     * @param ResultCodeEnum У�鲻���׳��쳣���쳣��
     * @param msg �쳣��Ϣ
     * @throws DnmException
     */
    public static void notBlank(String str, ResultCodeEnum code, String msg) throws DnmException {
        if (StringUtil.isBlank(str)) {
            throwDnmException(code, msg);
        }
    }

    /**
     * �����Ƿ�Ϊ�գ����Ϊ���׳��쳣��
     * 
     * @param collection ����
     * @param ResultCodeEnum У�鲻���׳��쳣���쳣��
     * @param msg �쳣��Ϣ
     * @throws DnmException
     */
    public static void notEmpty(Collection<?> collection, ResultCodeEnum code, String msg)
                                                                                          throws DnmException {
        if (CollectionUtils.isEmpty(collection)) {
            throwDnmException(code, msg);
        }
    }

    /**
     * �����Ƿ�Ϊ<code>true</code>����������׳��쳣��
     * 
     * @param expected ����ֵ
     * @param code �쳣��
     * @param msg �쳣��Ϣ
     * @throws DnmException
     */
    public static void isTrue(boolean expected, ResultCodeEnum code, String msg)
                                                                                throws DnmException {
        if (!expected) {
            throwDnmException(code, msg);
        }
    }

    /**
     * �����Ƿ�Ϊ<code>false</code>����������׳��쳣��
     * 
     * @param expected ����ֵ
     * @param code �쳣��
     * @param msg �쳣��Ϣ
     * @throws DnmException
     */
    public static void isFalse(boolean expected, ResultCodeEnum code, String msg)
                                                                                 throws DnmException {
        if (expected) {
            throwDnmException(code, msg);
        }
    }

    /**
     * �Ƚ����������Ƿ���ȣ�������׳��쳣����������ΪnullҲ��ʾ���
     * 
     * @param origin    ԭ����
     * @param target    Ŀ�����
     * @param code      �Ƚ�ʧ���쳣��
     * @param msg       �Ƚ�ʧ����Ϣ
     * 
     * @throws DnmException
     */
    public static void equals(Object origin, Object target, ResultCodeEnum code, String msg)
                                                                                            throws DnmException {
        // ���ֱ�ӷ���
        if (origin == target) {
            return;
        }

        // ����һ��Ϊnull���߲�����׳��쳣
        if (origin == null || target == null || !origin.equals(target)) {
            throwDnmException(code, msg);
        }
    }

    /**
     * �����ܸ��쳣���׳�
     * 
     * @param code �쳣��
     * @param msg �쳣����
     * @throws DnmException
     */
    public static void throwDnmException(ResultCodeEnum code, String msg) throws DnmException {
        throw new DnmException(code, msg);
    }
}
