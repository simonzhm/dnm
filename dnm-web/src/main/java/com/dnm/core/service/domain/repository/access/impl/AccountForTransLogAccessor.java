/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmAccountDAO;
import com.dnm.core.service.domain.convertor.AccountConvertor;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 账户数据访问器(AccountTransLogModel)
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountAccessor.java, v 0.1 2014-5-6 下午11:59:35 hongmin.zhonghm Exp $
 */
public class AccountForTransLogAccessor extends AbstractDataAccessor {

    /** 账户DAO */
    @Resource
    private DnmAccountDAO dnmAccountDAO;

    /** 
     * @see com.dnm.core.service.domain.repository.access.AbstractDataAccessor#reStore(com.dnm.core.service.domain.model.DomainModel)
     */
    @Override
    public void reStore(DomainModel model) {
        AccountTransLogModel atlm = (AccountTransLogModel) model;
        AccountModel dam = atlm.getDebitAccountModel();
        AccountModel cam = atlm.getCreditAccountModel();
        dnmAccountDAO.update(AccountConvertor.convert2DO(dam));
        dnmAccountDAO.update(AccountConvertor.convert2DO(cam));
    }
}
