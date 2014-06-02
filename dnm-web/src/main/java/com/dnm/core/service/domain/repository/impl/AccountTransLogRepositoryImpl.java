/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.core.service.domain.repository.AccountTransLogRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogRepositoryImpl.java, v 0.1 2014-5-14 ����9:52:02 hongmin.zhonghm Exp $
 */
public class AccountTransLogRepositoryImpl extends AbstractDomainService implements
                                                                        AccountTransLogRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.AccountTransLogRepository#store(com.dnm.core.service.domain.model.bill.AccountTransLogModel)
     */
    @Override
    public void store(AccountTransLogModel model) {
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
    private AccessorActionDef defAction(AccountTransLogModel model) {
        AccessorActionDef actionDef = defAction(AccessorEnum.ACCOUNT_TRANS_LOG,
            RepoActionEnum.STORE);
        actionDef.addAction(AccessorEnum.ACCOUNT_FOR_TRANS_LOG, RepoActionEnum.RESTORE);
        actionDef.addAction(AccessorEnum.ACCOUNT_LOG, RepoActionEnum.STORE);

        return actionDef;
    }

}
