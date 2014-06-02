/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.UserDomainService;
import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.core.service.domain.repository.UserRepository;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserDomainServiceImpl.java, v 0.1 2014-4-13 上午2:49:01 hongmin.zhonghm Exp $
 */
@Service(value = "userDomainService")
public class UserDomainServiceImpl extends AbstractDomainService implements UserDomainService {

    /** 用户仓储 */
    @Resource
    private UserRepository userRepository;

    /** 
     * @see com.dnm.core.service.domain.UserDomainService#regist(com.dnm.core.service.domain.model.bill.UserModel)
     */
    @Override
    public void regist(UserModel userModel) {
        userRepository.store(userModel);

    }

    /** 
     * @see com.dnm.core.service.domain.UserDomainService#login(com.dnm.core.service.domain.model.bill.UserModel)
     */
    @Override
    public void login(UserModel userModel) {
        AssertUtil.notBlank(userModel.getUsername(), ResultCodeEnum.BIZ_PARAM_ILLEGAL,
            "userModel.username is empty");
        AssertUtil.notBlank(userModel.getPassword(), ResultCodeEnum.BIZ_PARAM_ILLEGAL,
            "userModel.password is empty");

        userRepository.loadByUserNameAndPwd(userModel);

        //检查是否加载成功
        AssertUtil.notBlank(userModel.getId(), ResultCodeEnum.USER_BIZ_ERROR,
            "username or password incorrect");
    }

}
