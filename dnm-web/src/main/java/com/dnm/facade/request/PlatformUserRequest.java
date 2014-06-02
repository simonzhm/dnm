/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * �������ƽ̨�û����󵥾�
 * 
 * @author hongmin.zhonghm
 * @version $Id: PlatformUserRequest.java, v 0.1 2014-5-5 ����10:54:38 hongmin.zhonghm Exp $
 */
public class PlatformUserRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -3832517615228411618L;

    /** Ͷ��ƽ̨�û�ID */
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
