/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access.impl;

import javax.annotation.Resource;

import com.dnm.core.common.dal.daointerface.DnmInvestRcdDAO;
import com.dnm.core.common.dal.dataobject.DnmInvestRcdDO;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.repository.access.AbstractDataAccessor;

/**
 * 银行数据访问器
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRcdAccessor.java, v 0.1 2014-7-10 下午11:59:35 hongmin.zhonghm Exp $
 */
public class InvestRcdAccessor  extends AbstractDataAccessor{

	/** 投标DAO */
    @Resource
    private DnmInvestRcdDAO dnmInvestRcdDAO;
    
	@Override
	public void store(DomainModel model) {
		dnmInvestRcdDAO.insert(convert2DO((InvestRecordModel)model));
	}

	/**
     * 填充DO
     * 
     * @param model
     * @return
     */
    private DnmInvestRcdDO convert2DO(InvestRecordModel model) {
    	DnmInvestRcdDO investRcdDO = new DnmInvestRcdDO();
        if (model != null) {
            investRcdDO.setId(model.getId());
            investRcdDO.setPlatformUserId(model.getPlatformUserId());
            investRcdDO.setPeriod(model.getPeriod());
            investRcdDO.setPeriodType(model.getPeriodType());
            investRcdDO.setRepayMethod(model.getRepayMethod());
            investRcdDO.setInvestAmt(model.getInvestAmt());
            investRcdDO.setInvestDate(model.getInvestDate());
            investRcdDO.setInterestRateType(model.getInterestRateType());
            investRcdDO.setInterestRate(model.getInterestRate());
            investRcdDO.setInterestAmt(model.getInterestAmt());
            investRcdDO.setCostAmt(model.getCostAmt());
            investRcdDO.setPriceAmt(model.getPriceAmt());
            investRcdDO.setFeeRate(model.getFeeRate());
            investRcdDO.setIsFinish(model.getIsFinish());
            investRcdDO.setMemo(model.getRemark());
            investRcdDO.setGmtCreate(model.getGmtCreate());
            investRcdDO.setGmtModified(model.getGmtModified());
        }
        return investRcdDO;
    }
}
