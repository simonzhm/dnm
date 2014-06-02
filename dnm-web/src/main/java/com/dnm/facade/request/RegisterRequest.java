/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;
import com.dnm.facade.anotation.RequestFieldEncrypt;

/**
 * 注册请求单据
 * 
 * @author hongmin.zhonghm
 * @version $Id: RegisterRequest.java, v 0.1 2014-4-13 上午1:48:00 hongmin.zhonghm Exp $
 */
public class RegisterRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = 6766068348232263263L;

    /** 用户名 */
    @RequestFieldCheck(notEmpty = true, minLength = 6)
    @RequestFieldEncrypt
    private String            username;

    /** 密码 */
    @RequestFieldCheck(notEmpty = true, minLength = 6)
    @RequestFieldEncrypt
    private String            password;

    /** 邮箱 */
    @RequestFieldCheck(notEmpty = true, isEmail = true)
    private String            email;

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

    /**
     * Getter method for property <tt>email</tt>.
     * 
     * @return property value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property <tt>email</tt>.
     * 
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
