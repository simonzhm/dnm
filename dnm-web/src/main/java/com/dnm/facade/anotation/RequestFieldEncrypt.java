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
 * 加密注解，表示该字段信息需要加密
 * @author hongmin.zhonghm
 * @version $Id: RequestFieldEncrypt.java, v 0.1 2014-5-1 下午9:52:56 hongmin.zhonghm Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface RequestFieldEncrypt {

    /**加密格式，全加密，部分加密，由不同加密处理器处理*/
    String format() default EncryptFormatConstant.DEFAULT;
}
