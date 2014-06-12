/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.PlatformDomainService;
import com.dnm.core.service.domain.adapter.PlatformModelAdapter;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.core.service.domain.model.bill.PlatformUserModel;
import com.dnm.core.service.domain.repository.PlatformRepository;
import com.dnm.facade.api.AccountServiceFacade;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.constant.ThirdAccountTypeEnum;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.result.AccountResult;

/**
 * ƽ̨�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankDomainServiceImpl.java, v 0.1 2014-5-6 ����12:53:31 hongmin.zhonghm Exp $
 */
public class PlatformDomainServiceImpl extends AbstractDomainService implements
                                                                    PlatformDomainService {

    /** ƽ̨�ִ� */
    @Resource
    private PlatformRepository   platformRepository;

    /** ��ͷ����ӿ� */
    @Resource
    private AccountServiceFacade accountServiceFacade;

    /** ����ģ�������� */
    @Resource
    private PlatformModelAdapter platformModelAdapter;

    /** 
     * @see com.dnm.core.service.domain.PlatformDomainService#addPlatform(com.dnm.core.service.domain.model.bill.PlatformModel)
     */
    @Override
    public void addPlatform(PlatformModel model) {
        platformRepository.store(model);
    }

    /** 
     * @see com.dnm.core.service.domain.PlatformDomainService#addPlatformUsers(com.dnm.core.service.domain.model.bill.PlatformModel)
     */
    @Override
    public void addPlatformUsers(PlatformModel model) {
        //���������ģ���˻�id
        openAccount(model);

        //�־û�ģ��
        platformRepository.store(model);
    }

    /**
     * ���������ģ���˻�id
     * 
     * @return
     */
    private void openAccount(PlatformModel model) {
        List<PlatformUserModel> puModels = model.getNewPlatformUserModels();
        for (PlatformUserModel puModel : puModels) {
            List<ThirdAccountTypeEnum> types = ThirdAccountTypeEnum.getPlatformSubAccountTypes();
            for (ThirdAccountTypeEnum type : types) {
                AccountResult result = null;
                OpenAccountRequest requestData = new OpenAccountRequest();
                requestData.setUserId(puModel.getUserId());
                requestData.setAccountName(type.getName());
                requestData.setAccountType(type.getCode());
                requestData.setBalance("0");
                requestData.setCurrency(CurrencyEnum.CNY.getCode());
                requestData.setDirection(type.getDirection().getCode());
                result = accountServiceFacade.openAccount(requestData);

                //���ģ��
                platformModelAdapter.fillPlatformUserModel(puModel, result);

                AssertUtil.isTrue(result.isSuccess(),
                    ResultCodeEnum.getByCode(result.getResultCode()), result.getResulstMsg());
            }
        }

    }

}
