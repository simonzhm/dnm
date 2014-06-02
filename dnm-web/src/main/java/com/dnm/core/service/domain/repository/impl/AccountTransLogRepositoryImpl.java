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
 * @version $Id: AccountTransLogRepositoryImpl.java, v 0.1 2014-5-14 下午9:52:02 hongmin.zhonghm Exp $
 */
public class AccountTransLogRepositoryImpl extends AbstractDomainService implements
                                                                        AccountTransLogRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.AccountTransLogRepository#store(com.dnm.core.service.domain.model.bill.AccountTransLogModel)
     */
    @Override
    public void store(AccountTransLogModel model) {
        //step1.模型校验
        model.checkConsistency();

        //定义仓储行为
        AccessorActionDef actionDef = defAction(model);

        //模型存储
        accessModel(model, actionDef);
    }

    /**
     * 根据模型定义动作
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
