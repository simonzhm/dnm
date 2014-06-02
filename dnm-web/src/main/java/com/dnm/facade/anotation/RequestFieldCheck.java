/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �����ֶ�����ע��
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestChecker.java, v 0.1 2014-4-7 ����9:19:48 hongmin.zhonghm Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface RequestFieldCheck {

    /** �Ƿ����Ϊ�գ����ȴ���0�� */
    boolean notEmpty() default false;

    /** �Ƿ����Ϊ�� */
    boolean notNull() default false;

    /** �Ƿ�email��ʽ */
    boolean isEmail() default false;

    /** �̶����� */
    int length() default 0;

    /** ��С���� */
    int minLength() default 0;

    /** ��󳤶� */
    int maxLength() default 0;

    /** ���� */
    boolean positive() default false;

    /** ���� */
    boolean integer() default false;

}
