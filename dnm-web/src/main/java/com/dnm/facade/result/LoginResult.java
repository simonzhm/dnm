/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.result;

import org.apache.struts2.json.annotations.JSON;

/**
 * 登陆结果
 * 
 * @author hongmin.zhonghm
 * @version $Id: LoginResult.java, v 0.1 2014-5-4 下午10:08:10 hongmin.zhonghm Exp $
 */
public class LoginResult extends BaseResult {

    /** serialVersionUID */
    private static final long serialVersionUID = 8139893476567916675L;

    /** 用户ID */
    private String            userId;

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    @JSON(serialize = false)
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
