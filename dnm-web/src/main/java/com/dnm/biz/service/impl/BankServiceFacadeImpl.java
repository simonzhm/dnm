/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.service.domain.BankDomainService;
import com.dnm.core.service.domain.factory.BankFactory;
import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.facade.api.BankServiceFacade;
import com.dnm.facade.request.AddBankRequest;
import com.dnm.facade.result.BaseResult;

/**
 * ���з���ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankServiceFacadeImpl.java, v 0.1 2014-5-8 ����1:49:59 hongmin.zhonghm Exp $
 */
public class BankServiceFacadeImpl extends BizServiceTemplate implements BankServiceFacade {
    /** ����ģ�͹��� */
    @Resource
    private BankFactory       bankFactory;

    /** ������� */
    @Resource
    private BankDomainService bankDomainService;

    /** 
     * @see com.dnm.facade.api.BankServiceFacade#addBank(com.dnm.facade.request.AddBankRequest)
     */
    @Override
    public BaseResult addBank(AddBankRequest requestData) {
        return execute(new BizServiceCallBack<AddBankRequest, BankModel, BaseResult>(requestData,
            transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected BankModel doCallBack(AddBankRequest parameter) {
                //��װģ��
                BankModel model = bankFactory.compose(parameter);

                //����������
                bankDomainService.addBank(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected BaseResult composeResult(BankModel model, Exception e) {
                BaseResult result = new BaseResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("bank exists already");
                    }
                }
                return result;
            }

        });
    }
}
