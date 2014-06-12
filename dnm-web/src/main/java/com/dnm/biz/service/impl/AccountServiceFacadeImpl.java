/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import com.dnm.biz.helper.AccountHelper;
import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.service.domain.AccountDomainService;
import com.dnm.core.service.domain.factory.AccountFactory;
import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.facade.api.AccountServiceFacade;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.request.QueryAccountByUserIdTypeRequest;
import com.dnm.facade.request.QueryAccountRequest;
import com.dnm.facade.result.AccountResult;

/**
 * �˻�����ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountServiceFacadeImpl.java, v 0.1 2014-5-5 ����12:18:10 hongmin.zhonghm Exp $
 */
public class AccountServiceFacadeImpl extends BizServiceTemplate implements AccountServiceFacade {

    /** ����ģ�͹��� */
    @Resource
    private AccountFactory       accountFactory;

    /** ������� */
    @Resource
    private AccountDomainService accountDomainService;

    /** 
     * @see com.dnm.facade.api.AccountServiceFacade#openAccount(com.dnm.facade.request.OpenAccountRequest)
     */
    @Override
    public AccountResult openAccount(final OpenAccountRequest requestData) {
        return execute(new BizServiceCallBack<OpenAccountRequest, AccountModel, AccountResult>(
            requestData, transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected AccountModel doCallBack(OpenAccountRequest pamateter) {
                //��װģ��
                AccountModel model = accountFactory.compose(pamateter);

                //����������
                accountDomainService.openAccount(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected AccountResult composeResult(AccountModel model, Exception e) {
                AccountResult result = new AccountResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                    result.setAccount(AccountHelper.convert2VO(model));
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("account exists already");
                    }
                }
                return result;
            }

        });
    }

    /** 
     * @see com.dnm.facade.api.AccountServiceFacade#queryAccount(com.dnm.facade.request.QueryAccountRequest)
     */
    @Override
    public AccountResult queryAccount(QueryAccountRequest requestData) {
        return execute(new BizServiceCallBack<QueryAccountRequest, AccountModel, AccountResult>(
            requestData, null) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected AccountModel doCallBack(QueryAccountRequest pamateter) {
                //��װģ��
                AccountModel model = accountFactory.compose(pamateter);

                //����������
                accountDomainService.queryAccount(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected AccountResult composeResult(AccountModel model, Exception e) {
                AccountResult result = new AccountResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                    result.setAccount(AccountHelper.convert2VO(model));
                } else {
                    ResultHelper.fillFailResult(result, e);
                }
                return result;
            }

        });
    }

    /** 
     * @see com.dnm.facade.api.AccountServiceFacade#queryAccountByUserIdType(com.dnm.facade.request.QueryAccountByUserIdTypeRequest)
     */
    @Override
    public AccountResult queryAccountByUserIdType(QueryAccountByUserIdTypeRequest requestData) {
        return execute(new BizServiceCallBack<QueryAccountByUserIdTypeRequest, AccountModel, AccountResult>(
            requestData, null) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected AccountModel doCallBack(QueryAccountByUserIdTypeRequest pamateter) {
                //��װģ��
                AccountModel model = accountFactory.compose(pamateter);

                //����������
                accountDomainService.queryAccountByUserIdType(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected AccountResult composeResult(AccountModel model, Exception e) {
                AccountResult result = new AccountResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                    result.setAccount(AccountHelper.convert2VO(model));
                } else {
                    ResultHelper.fillFailResult(result, e);
                }
                return result;
            }

        });
    }

}
