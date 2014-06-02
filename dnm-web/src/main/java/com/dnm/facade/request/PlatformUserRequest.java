/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 添加网贷平台用户请求单据
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformUserRequest.java, v 0.1 2014-5-5 上午10:54:38 hongmin.zhonghm Exp $
 */
public class PlatformUserRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** 投资平台用户ID */
    @RequestFieldCheck(notEmpty = true)
    private String            platformUserId;

    /**
     * Getter method for property <tt>platformUserId</tt>.
     * 
     * @return property value of platformUserId
     */
    public String getPlatformUserId() {
        return platformUserId;
    }

    /**
     * Setter method for property <tt>platformUserId</tt>.
     * 
     * @param platformUserId value to be assigned to property platformUserId
     */
    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId;
    }

}
