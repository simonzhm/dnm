/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * ��session���ݵĻ������󵥾�
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseSessionRequestOrder.java, v 0.1 2014-5-5 ����11:51:51 hongmin.zhonghm Exp $
 */
public class BaseSessionRequestOrder extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = 504662802182198825L;

    /** �û�ID ����Ϊ16*/
    @RequestFieldCheck(notEmpty = true, length = 16)
    private String            userId;

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     * 
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
