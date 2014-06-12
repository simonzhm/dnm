/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.repository.AccountRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * 账户仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountRepositoryImpl.java, v 0.1 2014-5-6 下午11:56:49 hongmin.zhonghm Exp $
 */
public class AccountRepositoryImpl extends AbstractDomainService implements AccountRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.AccountRepository#store(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void store(AccountModel model) {
        //step1.模型校验
        model.checkConsistency();

        //定义仓储行为
        AccessorActionDef actionDef = defAction(AccessorEnum.ACCOUNT, RepoActionEnum.STORE);

        //模型处理
        accessModel(model, actionDef);
    }

    /** 
     * @see com.dnm.core.service.domain.repository.AccountRepository#fill(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void fill(AccountModel model) {
        //定义仓储行为
        AccessorActionDef actionDef = defAction(AccessorEnum.ACCOUNT, RepoActionEnum.LOAD);

        //模型处理
        accessModel(model, actionDef);
    }

    /** 
     * @see com.dnm.core.service.domain.repository.AccountRepository#reFill(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void reFill(AccountModel model) {
        //定义仓储行为
        AccessorActionDef actionDef = defAction(AccessorEnum.ACCOUNT, RepoActionEnum.RELOAD);

        //模型处理
        accessModel(model, actionDef);
    }

    /** 
     * @see com.dnm.core.service.domain.repository.AccountRepository#active(com.dnm.core.service.domain.model.bill.AccountModel)
     */
    @Override
    public void active(AccountModel model) {
        //定义仓储行为
        AccessorActionDef actionDef = defAction(AccessorEnum.ACCOUNT, RepoActionEnum.ACTIVE);

        //模型处理
        accessModel(model, actionDef);
    }

}
