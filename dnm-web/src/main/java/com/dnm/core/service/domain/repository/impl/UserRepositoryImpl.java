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
 * �û��ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserRepositoryImpl.java, v 0.1 2014-4-13 ����2:52:58 hongmin.zhonghm Exp $
 */
@Service(value = "userRepository")
public class UserRepositoryImpl extends AbstractDomainService implements UserRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.UserRepository#store(com.dnm.core.service.domain.model.bill.UserModel)
     */
    @Override
    public void store(UserModel userModel) {
        //step1.ģ��У��
        userModel.checkConsistency();

        //����ִ���Ϊ
        AccessorActionDef actionDef = defAction(AccessorEnum.USER, RepoActionEnum.STORE);

        //ģ�ʹ洢
        accessModel(userModel, actionDef);
    }

    /** 
     * @see com.dnm.core.service.domain.repository.UserRepository#loadByUserNameAndPwd(com.dnm.core.service.domain.model.bill.UserModel)
     */
    @Override
    public void loadByUserNameAndPwd(UserModel userModel) {
        //����ִ���Ϊ
        AccessorActionDef actionDef = defAction(AccessorEnum.USER, RepoActionEnum.RELOAD);

        //ģ�ʹ洢
        accessModel(userModel, actionDef);
    }

}
