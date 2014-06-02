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
 * �����������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankDomainServiceImpl.java, v 0.1 2014-5-6 ����12:53:31 hongmin.zhonghm Exp $
 */
public class BankDomainServiceImpl extends AbstractDomainService implements BankDomainService {

    /** ���вִ� */
    @Resource
    private BankRepository       bankRepository;

    /** ����ģ�������� */
    @Resource
    private BankModelAdapter     bankModelAdapter;

    /** ��ͷ����ӿ� */
    @Resource
    private AccountServiceFacade accountServiceFacade;

    /** 
     * @see com.dnm.core.service.domain.BankDomainService#addBank(com.dnm.core.service.domain.model.bill.BankModel)
     */
    @Override
    public void addBank(BankModel model) {

        //���ÿ����ӿ�
        AccountResult opResult = openAccount(model);

        //����ģ��
        bankModelAdapter.fillBankModel(model, opResult);

        //�־û�ģ��
        bankRepository.store(model);

    }

    /**
     * ����
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
