/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldEncrypt;
import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: LoginRequest.java, v 0.1 2014-5-2 下午12:18:17 hongmin.zhonghm Exp $
 */
public class LoginRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = 3279918605305339977L;

    /** 用户名 */
    @RequestFieldCheck(notEmpty = true, minLength = 6)
    @RequestFieldEncrypt
    private String            username;

    /** 密码 */
    @RequestFieldCheck(notEmpty = true, minLength = 6)
    @RequestFieldEncrypt
    private String            password;

    /**
     * Getter method for property <tt>username</tt>.
     * 
     * @return property value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for property <tt>username</tt>.
     * 
     * @param username value to be assigned to property username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for property <tt>password</tt>.
     * 
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     * 
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
