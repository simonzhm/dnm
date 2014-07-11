/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmInvestDueinRcdDAO;
import com.dnm.core.common.dal.dataobject.DnmInvestDueinRcdDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.InvestDueinRecordModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 待收标访问器
 * 
 * @author hongmin.zhonghm
 * InvestDueinRcdAccessor.java下午5:56:37
 */
public class InvestDueinRcdAccessor extends AbstractDataAccessor{
	
	/** 待收标DAO */
    @Resource
    private DnmInvestDueinRcdDAO dnmInvestDueinRcdDAO;

	@Override
	public void store(DomainModel model) {
		InvestRecordModel investRecordModel = (InvestRecordModel)model;
		List<InvestDueinRecordModel> investDueinRecordModels = investRecordModel.getInvestDueinRecordModels();
		for(InvestDueinRecordModel investDueinRecordModel : investDueinRecordModels){
			dnmInvestDueinRcdDAO.insert(convert2DO(investDueinRecordModel));
		}
	}
    
	/**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmInvestDueinRcdDO convert2DO(InvestDueinRecordModel model) {
    	DnmInvestDueinRcdDO investDueinRcdDO = new DnmInvestDueinRcdDO();
        if (model != null) {
            investDueinRcdDO.setId(model.getId());
            investDueinRcdDO.setInvestRecordId(model.getInvestRecordId());
            investDueinRcdDO.setPeriodIndex(model.getPeriodIndex());
            investDueinRcdDO.setRepayAmt(model.getRepayAmt());
            investDueinRcdDO.setRepayInterestAmt(model.getRepayInterestAmt());
            investDueinRcdDO.setRepayDate(model.getRepayDate());
            investDueinRcdDO.setActualRepayDate(model.getActualRepayDate());
            investDueinRcdDO.setIsDelay(model.getIsDelay());
            investDueinRcdDO.setIsFinish(model.getIsFinish());
            investDueinRcdDO.setGmtCreate(model.getGmtCreate());
            investDueinRcdDO.setGmtModified(model.getGmtModified());
        }
        return investDueinRcdDO;
    }
}
