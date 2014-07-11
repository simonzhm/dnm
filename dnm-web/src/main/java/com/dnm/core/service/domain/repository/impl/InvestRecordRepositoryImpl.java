/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.repository.InvestRecordRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * 投标记录领域仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordRepositoryImpl.java, v 0.1 2014-5-25 下午7:26:22 hongmin.zhonghm Exp $
 */
public class InvestRecordRepositoryImpl extends AbstractDomainService implements InvestRecordRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.InvestRecordRepository#store(com.dnm.core.service.domain.model.bill.InvestRecordModel)
     */
    @Override
    public void store(InvestRecordModel model) {
    	//step1.模型校验
        model.checkConsistency();

        //定义仓储行为
        AccessorActionDef actionDef = defAction(model);

        //模型存储
        accessModel(model, actionDef);
    }
    
    /**
     * 定义访问器指令
     * @param model
     * @return
     */
    private AccessorActionDef defAction(InvestRecordModel model){
    	//主标
        AccessorActionDef actionDef = defAction(AccessorEnum.INVEST_RCD, RepoActionEnum.STORE);
        //明细标
        actionDef.addAction(AccessorEnum.INVEST_DUEIN_RCD, RepoActionEnum.STORE);
        //账户来源
        actionDef.addAction(AccessorEnum.INVEST_FROM_ACCOUNT, RepoActionEnum.STORE);
        //奖励费用
        actionDef.addAction(AccessorEnum.INVEST_PRICE_COST, RepoActionEnum.STORE);
        
        return actionDef;
    }

}
