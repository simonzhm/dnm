/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmInvestFromAccountDAO;
import com.dnm.core.common.dal.dataobject.DnmInvestFromAccountDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.InvestFromAccountModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 投标账户来源
 * 
 * @author hongmin.zhonghm
 * InvestFromAccountAccessor.java下午10:46:03
 */
public class InvestFromAccountAccessor extends AbstractDataAccessor {
	
	/** 投标账户来源DAO */
    @Resource
    private DnmInvestFromAccountDAO dnmInvestFromAccountDAO;

	@Override
	public void store(DomainModel model) {
		InvestRecordModel investRecordModel = (InvestRecordModel)model;
		List<InvestFromAccountModel> investFromAccountModels = investRecordModel.getInvstFromAccountModels();
		for(InvestFromAccountModel investFromAccountModel : investFromAccountModels){
			dnmInvestFromAccountDAO.insert(convert2DO(investFromAccountModel));
		}
	}

	/**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmInvestFromAccountDO convert2DO(InvestFromAccountModel model) {
    	DnmInvestFromAccountDO investFromAccountDO = new DnmInvestFromAccountDO();
        if (model != null) {
            investFromAccountDO.setInvestRecordId(model.getInvestRecordId());
            investFromAccountDO.setAccountId(model.getAccountId());
            investFromAccountDO.setAmount(model.getAmount());
            investFromAccountDO.setCurrency(model.getCurrency());
            investFromAccountDO.setGmtCreate(model.getGmtCreate());
            investFromAccountDO.setGmtModified(model.getGmtModified());
        }
        return investFromAccountDO;
    }
}
