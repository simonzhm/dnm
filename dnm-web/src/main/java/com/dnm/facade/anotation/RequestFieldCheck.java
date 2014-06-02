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
 * 请求字段配置注解
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestChecker.java, v 0.1 2014-4-7 下午9:19:48 hongmin.zhonghm Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface RequestFieldCheck {

    /** 是否可以为空（长度大于0） */
    boolean notEmpty() default false;

    /** 是否可以为空 */
    boolean notNull() default false;

    /** 是否email格式 */
    boolean isEmail() default false;

    /** 固定长度 */
    int length() default 0;

    /** 最小长度 */
    int minLength() default 0;

    /** 最大长度 */
    int maxLength() default 0;

    /** 正数 */
    boolean positive() default false;

    /** 整数 */
    boolean integer() default false;

}
