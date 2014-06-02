/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.service.domain.AccountTransferDomainService;
import com.dnm.core.service.domain.factory.AccountTransLogFactory;
import com.dnm.core.service.domain.model.bill.AccountTransLogModel;
import com.dnm.facade.api.AccountTransferServiceFacade;
import com.dnm.facade.request.AccountTransferRequest;
import com.dnm.facade.result.BaseResult;

/**
 * �˻����׽ӿ�ʵ��
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferServiceFacadeImpl.java, v 0.1 2014-5-15 ����1:32:11 hongmin.zhonghm Exp $
 */
public class AccountTransferServiceFacadeImpl extends BizServiceTemplate implements AccountTransferServiceFacade {
    /** ����ģ�͹��� */
    @Resource
    private AccountTransLogFactory       accountTransFactory;

    /** ������� */
    @Resource
    private AccountTransferDomainService accountTransferDomainService;

    /** 
     * @see com.dnm.facade.api.AccountTransferServiceFacade#transfer(com.dnm.facade.request.AccountTransferRequest)
     */
    @Override
    public BaseResult transfer(AccountTransferRequest requestData) {
        return execute(new BizServiceCallBack<AccountTransferRequest, AccountTransLogModel, BaseResult>(
            requestData, transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected AccountTransLogModel doCallBack(AccountTransferRequest pamateter) {
                //��װģ��
                AccountTransLogModel model = accountTransFactory.compose(pamateter);

                //����������
                accountTransferDomainService.accountTransfer(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected BaseResult composeResult(AccountTransLogModel model, Exception e) {
                BaseResult result = new BaseResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("account log exists already");
                    }
                }
                return result;
            }

        });
    }

}
