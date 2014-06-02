/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmBankDAO;
import com.dnm.core.common.dal.dataobject.DnmBankDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 银行数据访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankAccessor.java, v 0.1 2014-5-6 下午11:59:35 hongmin.zhonghm Exp $
 */
public class BankAccessor extends AbstractDataAccessor {

    /** 银行DAO */
    @Resource
    private DnmBankDAO dnmBankDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#store(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void store(DomainModel model) {
        BankModel accountModel = (BankModel) model;
        dnmBankDAO.insert(convert2DO(accountModel));
    }

    /**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmBankDO convert2DO(BankModel model) {
        DnmBankDO bankDO = new DnmBankDO();
        if (model != null) {
            bankDO.setId(model.getId());
            bankDO.setUserId(model.getUserId());
            bankDO.setBankId(model.getBankId());
            bankDO.setBankName(model.getBankName());
            bankDO.setDirection(model.getDirection());
            bankDO.setAccountId(model.getAccountId());
            bankDO.setBillDate(model.getBillDate());
            bankDO.setRepayDate(model.getRepayDate());
            bankDO.setGmtCreate(model.getGmtCreate());
            bankDO.setGmtModified(model.getGmtModified());
        }
        return bankDO;
    }

}
