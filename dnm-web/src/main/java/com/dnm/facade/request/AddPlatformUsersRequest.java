/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import java.util.ArrayList;
import java.util.List;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * �����������ƽ̨�û����󵥾�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AddPlatformUsersRequest.java, v 0.1 2014-5-5 ����10:54:38 hongmin.zhonghm Exp $
 */
public class AddPlatformUsersRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long         serialVersionUID = -3832517615228411618L;

    /** ƽ̨ID */
    @RequestFieldCheck(notEmpty = true)
    private String                    platformId;

    /** ƽ̨�û� */
    @RequestFieldCheck(notEmpty = true)
    private List<PlatformUserRequest> platformUsers    = new ArrayList<PlatformUserRequest>();

    /**
     * Getter method for property <tt>platformId</tt>.
     * 
     * @return property value of platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Setter method for property <tt>platformId</tt>.
     * 
     * @param platformId value to be assigned to property platformId
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    /**
     * Getter method for property <tt>platformUsers</tt>.
     * 
     * @return property value of platformUsers
     */
    public List<PlatformUserRequest> getPlatformUsers() {
        return platformUsers;
    }

    /**
     * Setter method for property <tt>platformUsers</tt>.
     * 
     * @param platformUsers value to be assigned to property platformUsers
     */
    public void setPlatformUsers(List<PlatformUserRequest> platformUsers) {
        this.platformUsers = platformUsers;
    }

}
