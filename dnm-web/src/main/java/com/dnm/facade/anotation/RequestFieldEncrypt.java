/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dnm.core.common.constant.EncryptFormatConstant;

/**
 * ����ע�⣬��ʾ���ֶ���Ϣ��Ҫ����
 * @author hongmin.zhonghm
 * @version $Id: RequestFieldEncrypt.java, v 0.1 2014-5-1 ����9:52:56 hongmin.zhonghm Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface RequestFieldEncrypt {

    /**���ܸ�ʽ��ȫ���ܣ����ּ��ܣ��ɲ�ͬ���ܴ���������*/
    String format() default EncryptFormatConstant.DEFAULT;
}
