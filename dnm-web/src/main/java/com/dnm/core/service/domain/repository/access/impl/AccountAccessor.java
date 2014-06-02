/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmAccountDAO;
import com.dnm.core.common.dal.dataobject.DnmAccountDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 账户数据访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountAccessor.java, v 0.1 2014-5-6 下午11:59:35 hongmin.zhonghm Exp $
 */
public class AccountAccessor extends AbstractDataAccessor {

    /** 账户DAO */
    @Resource
    private DnmAccountDAO dnmAccountDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        AccountModel accountModel = (AccountModel) model;
        dnmAccountDAO.insert(convert2DO(accountModel));
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#fill(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void fill(DomainModel model) {
        AccountModel accountModel = (AccountModel) model;
        DnmAccountDO accountDo = dnmAccountDAO.load(accountModel.getAccountId());
        convert2Model(accountModel, accountDo);
    }

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#lockFill(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void lockFill(DomainModel model) {
        AccountModel accountModel = (AccountModel) model;
        DnmAccountDO accountDo = dnmAccountDAO.active(accountModel.getAccountId());
        convert2Model(accountModel, accountDo);
    }

    /**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmAccountDO convert2DO(AccountModel model) {
        DnmAccountDO accountDO = new DnmAccountDO();
        if (model != null) {
            accountDO.setUserId(model.getUserId());
            accountDO.setAccountId(model.getAccountId());
            accountDO.setAccountName(model.getAccountName());
            accountDO.setAccountType(model.getAccountType());
            accountDO.setSubAccountType(model.getSubAccountType());
            accountDO.setBalance(model.getBalance());
            accountDO.setCurrency(model.getCurrency());
            accountDO.setDirection(model.getDirection());
            accountDO.setGmtCreate(model.getGmtCreate());
            accountDO.setGmtModified(model.getGmtModified());
        }
        return accountDO;
    }

    /**
     * 填充模型
     * 
     * @param model
     * @param dbObject
     * @return
     */
    private void convert2Model(AccountModel model, DnmAccountDO dbObject) {
        if (dbObject != null) {
            model.setUserId(dbObject.getUserId());
            model.setAccountId(dbObject.getAccountId());
            model.setAccountName(dbObject.getAccountName());
            model.setAccountType(dbObject.getAccountType());
            model.setSubAccountType(dbObject.getSubAccountType());
            model.setBalance(dbObject.getBalance());
            model.setCurrency(dbObject.getCurrency());
            model.setDirection(dbObject.getDirection());
            model.setGmtCreate(dbObject.getGmtCreate());
            model.setGmtModified(dbObject.getGmtModified());
        }
    }
}
