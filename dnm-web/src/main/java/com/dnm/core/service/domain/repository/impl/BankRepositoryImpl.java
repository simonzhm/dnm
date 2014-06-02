/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.core.service.domain.repository.BankRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * ���вִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankRepositoryImpl.java, v 0.1 2014-5-6 ����11:56:49 hongmin.zhonghm Exp $
 */
public class BankRepositoryImpl extends AbstractDomainService implements BankRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.AccountRepository#store(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void store(BankModel model) {
        //step1.ģ��У��
        model.checkConsistency();

        //����ִ���Ϊ
        AccessorActionDef actionDef = defAction(AccessorEnum.BANK, RepoActionEnum.STORE);

        //ģ�ʹ洢
        accessModel(model, actionDef);
    }

}
