/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmAccountLogDAO;
import com.dnm.core.service.domain.convertor.AccountLogConvertor;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.AccountLogModel;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 账户交易日志数据访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogAccessor.java, v 0.1 2014-5-6 下午11:59:35 hongmin.zhonghm Exp $
 */
public class AccountLogAccessor extends AbstractDataAccessor {

    /** 账户日志DAO */
    @Resource
    private DnmAccountLogDAO dnmAccountLogDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        AccountTransLogModel accountTransLogModel = (AccountTransLogModel) model;
        AccountLogModel debitAccountModel = accountTransLogModel.getDebitAccountModel()
            .getAccountLogModel();
        if (debitAccountModel != null) {
            dnmAccountLogDAO.insert(AccountLogConvertor.convert2DO(debitAccountModel));
        }
        AccountLogModel creditAccountModel = accountTransLogModel.getCreditAccountModel()
            .getAccountLogModel();
        if (creditAccountModel != null) {
            dnmAccountLogDAO.insert(AccountLogConvertor.convert2DO(creditAccountModel));
        }
    }

}
