/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmInvestPriceCostDAO;
import com.dnm.core.common.dal.dataobject.DnmInvestPriceCostDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.InvestPriceCostModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 奖励及费用访问器
 * 
 * @author hongmin.zhonghm
 * InvestPriceCostAccessor.java下午11:51:11
 */
public class InvestPriceCostAccessor extends AbstractDataAccessor {

	/** 投标账户来源DAO */
    @Resource
    private DnmInvestPriceCostDAO dmnInvestPriceCostDAO;
    
	@Override
	public void store(DomainModel model) {
		InvestRecordModel investRecordModel = (InvestRecordModel)model;
		List<InvestPriceCostModel> investPriceCostModels = investRecordModel.getNewInvestPriceCostModels();
		for(InvestPriceCostModel investPriceCostModel : investPriceCostModels){
			dmnInvestPriceCostDAO.insert(convert2DO(investPriceCostModel));
		}
	}

	/**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmInvestPriceCostDO convert2DO(InvestPriceCostModel model) {
    	DnmInvestPriceCostDO investPriceCostDO = new DnmInvestPriceCostDO();
        if (model != null) {
            investPriceCostDO.setId(model.getId());
            investPriceCostDO.setGuid(model.getGuid());
            investPriceCostDO.setBizId(model.getBizId());
            investPriceCostDO.setTransCode(model.getTransCode());
            investPriceCostDO.setTransSubCode(model.getTransSubCode());
            investPriceCostDO.setOrigTransAmt(model.getOrigTransAmt());
            investPriceCostDO.setTransRate(model.getTransRate());
            investPriceCostDO.setTransAmt(model.getTransAmt());
            investPriceCostDO.setTransCurrency(model.getTransCurrency());
            investPriceCostDO.setMemo(model.getMemo());
            investPriceCostDO.setIsFinish(model.getIsFinish());
            investPriceCostDO.setGmtCreate(model.getGmtCreate());
            investPriceCostDO.setGmtModified(model.getGmtModified());
        }
        return investPriceCostDO;
    }
}
