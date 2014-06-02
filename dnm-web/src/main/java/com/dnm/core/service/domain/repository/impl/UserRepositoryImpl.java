/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import org.springframework.stereotype.Service;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.core.service.domain.repository.UserRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * 用户仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserRepositoryImpl.java, v 0.1 2014-4-13 上午2:52:58 hongmin.zhonghm Exp $
 */
@Service(value = "userRepository")
public class UserRepositoryImpl extends AbstractDomainService implements UserRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.UserRepository#store(com.dnm.core.service.domain.model.bill.UserModel)
     */
    @Override
    public void store(UserModel userModel) {
        //step1.模型校验
        userModel.checkConsistency();

        //定义仓储行为
        AccessorActionDef actionDef = defAction(AccessorEnum.USER, RepoActionEnum.STORE);

        //模型存储
        accessModel(userModel, actionDef);
    }

    /** 
     * @see com.dnm.core.service.domain.repository.UserRepository#loadByUserNameAndPwd(com.dnm.core.service.domain.model.bill.UserModel)
     */
    @Override
    public void loadByUserNameAndPwd(UserModel userModel) {
        //定义仓储行为
        AccessorActionDef actionDef = defAction(AccessorEnum.USER, RepoActionEnum.RELOAD);

        //模型存储
        accessModel(userModel, actionDef);
    }

}
