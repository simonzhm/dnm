/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 根据用户ID和账户子类型查询账户请求单据
 * 
 * @author hongmin.zhonghm
 * @version $Id: QueryAccountByUserIdTypeRequest.java, v 0.1 2014-5-5 上午10:54:38 hongmin.zhonghm Exp $
 */
public class QueryAccountByUserIdTypeRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** 子账户类型 */
    @RequestFieldCheck(notEmpty = true, length = 6)
    private String            subAccountType;

    /**
     * Getter method for property <tt>subAccountType</tt>.
     * 
     * @return property value of subAccountType
     */
    public String getSubAccountType() {
        return subAccountType;
    }

    /**
     * Setter method for property <tt>subAccountType</tt>.
     * 
     * @param subAccountType value to be assigned to property subAccountType
     */
    public void setSubAccountType(String subAccountType) {
        this.subAccountType = subAccountType;
    }

}
