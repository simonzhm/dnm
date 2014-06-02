/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import com.dnm.core.common.constant.LengthDefineConstant;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 用记领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserModel.java, v 0.1 2014-4-13 上午1:30:34 hongmin.zhonghm Exp $
 */
public class UserModel extends DomainModel {

    /** 用户id */
    private String id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 邮箱 */
    private String email;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        notNullCheck();
    }

    /**
     * 非空校验
     */
    private void notNullCheck() {
        AssertUtil.isTrue(StringUtil.isMeetLength(id, LengthDefineConstant.USER_ID_LENGTH),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "UserModel.id is illegal");
        AssertUtil.notBlank(username, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "UserModel.username is empty");
        AssertUtil.notBlank(password, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "UserModel.password is empty");
        AssertUtil.notBlank(email, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "UserModel.email is empty");
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

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
