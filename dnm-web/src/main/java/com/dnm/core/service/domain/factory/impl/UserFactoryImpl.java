/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.dnm.core.common.DnmContextHolder;
import com.dnm.core.common.util.DBKeyUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.factory.UserFactory;
import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.facade.request.LoginRequest;
import com.dnm.facade.request.RegisterRequest;

/**
 * 用户领域模型工厂实现类
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserFactoryImpl.java, v 0.1 2014-4-13 下午2:39:04 hongmin.zhonghm Exp $
 */
@Service(value = "userFactory")
public class UserFactoryImpl extends AbstractDomainService implements UserFactory {

    /** 
     * @see com.dnm.core.service.domain.factory.UserFactory#compose(com.dnm.facade.request.RegisterRequest)
     */
    @Override
    public UserModel compose(RegisterRequest requestData) {
        UserModel model = new UserModel();
        //从上下文中取出数据
        Date date = DnmContextHolder.getTime();

        model.setId(DBKeyUtil.complete16(date, sequenceService.getDnmUserSeq()));
        model.setUsername(requestData.getUsername());
        model.setPassword(requestData.getPassword());
        model.setEmail(requestData.getEmail());
        model.setGmtCreate(date);
        model.setGmtModified(date);
        return model;
    }

    /** 
     * @see com.dnm.core.service.domain.factory.UserFactory#compose(com.dnm.facade.request.LoginRequest)
     */
    @Override
    public UserModel compose(LoginRequest requestData) {
        UserModel model = new UserModel();
        model.setUsername(requestData.getUsername());
        model.setPassword(requestData.getPassword());
        return model;
    }

}
