/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 请求单据基类
 * 
 * <ol>属性类型限制
 * <li>String</li>
 * <li>BaseRequestOrder</li>
 * <li>List&lt;BaseRequestOrder></li>
 * <li>List&lt;String></li>
 * </ol>
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseRequestOrder.java, v 0.1 2014-4-7 下午5:06:54 hongmin.zhonghm Exp $
 */
public class BaseRequestOrder implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4908126313501708463L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
