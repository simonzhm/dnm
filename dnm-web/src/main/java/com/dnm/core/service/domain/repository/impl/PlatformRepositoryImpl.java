/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.core.service.domain.repository.PlatformRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * ƽ̨�ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountRepositoryImpl.java, v 0.1 2014-5-6 ����11:56:49 hongmin.zhonghm Exp $
 */
public class PlatformRepositoryImpl extends AbstractDomainService implements PlatformRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.PlatformRepository#store(com.dnm.core.service.domain.model.bill.PlatformModel)
     */
    @Override
    public void store(PlatformModel model) {
        //step1.ģ��У��
        model.checkConsistency();

        //����ִ���Ϊ
        AccessorActionDef actionDef = defAction(model);

        //ģ�ʹ洢
        accessModel(model, actionDef);
    }

    /**
     * ����ģ�Ͷ��嶯��
     * 
     * @param model
     * @return
     */
    private AccessorActionDef defAction(PlatformModel model) {
        AccessorActionDef actionDef = null;
        if (model.isAddPlatformUser()) {
            actionDef = defAction(AccessorEnum.PLATFORM_USER, RepoActionEnum.STORE);
            actionDef.addAction(AccessorEnum.PLATFORM_USER_ACCOUNT, RepoActionEnum.STORE);
        } else {
            actionDef = defAction(AccessorEnum.PLATFORM, RepoActionEnum.STORE);
        }
        return actionDef;
    }
}
