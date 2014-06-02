/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import javax.annotation.Resource;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.BankDomainService;
import com.dnm.core.service.domain.adapter.BankModelAdapter;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.core.service.domain.repository.BankRepository;
import com.dnm.facade.api.AccountServiceFacade;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.result.AccountResult;

/**
 * 银行领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankDomainServiceImpl.java, v 0.1 2014-5-6 上午12:53:31 hongmin.zhonghm Exp $
 */
public class BankDomainServiceImpl extends AbstractDomainService implements BankDomainService {

    /** 银行仓储 */
    @Resource
    private BankRepository       bankRepository;

    /** 领域模型适配器 */
    @Resource
    private BankModelAdapter     bankModelAdapter;

    /** 户头服务接口 */
    @Resource
    private AccountServiceFacade accountServiceFacade;

    /** 
     * @see com.dnm.core.service.domain.BankDomainService#addBank(com.dnm.core.service.domain.model.bill.BankModel)
     */
    @Override
    public void addBank(BankModel model) {

        //调用开户接口
        AccountResult opResult = openAccount(model);

        //补充模型
        bankModelAdapter.fillBankModel(model, opResult);

        //持久化模型
        bankRepository.store(model);

    }

    /**
     * 开户
     * 
     * @return
     */
    private AccountResult openAccount(BankModel model) {
        AccountModel aModel = model.getAccountModel();
        AccountResult result = null;
        OpenAccountRequest requestData = new OpenAccountRequest();
        requestData.setUserId(aModel.getUserId());
        requestData.setAccountName(aModel.getAccountName());
        requestData.setAccountType(aModel.getSubAccountType());
        requestData.setBalance(aModel.getBalance().toString());
        requestData.setCurrency(aModel.getCurrency());
        requestData.setDirection(aModel.getDirection());
        result = accountServiceFacade.openAccount(requestData);

        AssertUtil.isTrue(result.isSuccess(), ResultCodeEnum.getByCode(result.getResultCode()),
            result.getResulstMsg());

        return result;
    }

}
