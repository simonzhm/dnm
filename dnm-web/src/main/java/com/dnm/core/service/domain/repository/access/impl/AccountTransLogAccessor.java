/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmAccountTransLogDAO;
import com.dnm.core.common.dal.dataobject.DnmAccountTransLogDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * �˻�������־���ݷ�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogAccessor.java, v 0.1 2014-5-6 ����11:59:35 hongmin.zhonghm Exp $
 */
public class AccountTransLogAccessor extends AbstractDataAccessor {

    /** �˻�DAO */
    @Resource
    private DnmAccountTransLogDAO dnmAccountTransLogDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        AccountTransLogModel accountTransLogModel = (AccountTransLogModel) model;
        dnmAccountTransLogDAO.insert(convert2DO(accountTransLogModel));
    }

    /**
     * ���DO
     * 
     * @param model
     * @return
     */
    private DnmAccountTransLogDO convert2DO(AccountTransLogModel model) {
        DnmAccountTransLogDO accountTransLogDO = new DnmAccountTransLogDO();
        if (model != null) {
            accountTransLogDO.setId(model.getId());
            accountTransLogDO.setUserId(model.getUserId());
            accountTransLogDO.setGuid(model.getGuid());
            accountTransLogDO.setBizId(model.getBizId());
            accountTransLogDO.setTransCode(model.getTransCode());
            accountTransLogDO.setTransSubCode(model.getTransSubCode());
            accountTransLogDO.setTransAmt(model.getTransAmt());
            accountTransLogDO.setTransCurrency(model.getTransCurrency());
            accountTransLogDO.setTransTime(model.getTransTime());
            accountTransLogDO.setDebitAccount(model.getDebitAccount());
            accountTransLogDO.setCreditAccount(model.getCreditAccount());
            accountTransLogDO.setMemo(model.getMemo());
            accountTransLogDO.setGmtCreate(model.getGmtCreate());
            accountTransLogDO.setGmtModified(model.getGmtModified());
        }
        return accountTransLogDO;
    }

}
