/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.service.domain.UserDomainService;
import com.dnm.core.service.domain.factory.UserFactory;
import com.dnm.core.service.domain.model.bill.UserModel;
import com.dnm.facade.api.UserServiceFacade;
import com.dnm.facade.request.LoginRequest;
import com.dnm.facade.request.RegisterRequest;
import com.dnm.facade.result.LoginResult;
import com.dnm.facade.result.RegisterResult;

/**
 * �û�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: UserServiceFacadeImpl.java, v 0.1 2014-5-2 ����5:20:00 hongmin.zhonghm Exp $
 */
public class UserServiceFacadeImpl extends BizServiceTemplate implements UserServiceFacade {

    /** �û�����ģ�͹��� */
    @Resource
    private UserFactory       userFactory;

    /** �û�����ģ�ͷ��� */
    @Resource
    private UserDomainService userDomainService;

    /** 
     * @see com.dnm.facade.api.UserServiceFacade#regist(com.dnm.facade.request.RegisterRequest)
     */
    @Override
    public RegisterResult regist(RegisterRequest requestData) {

        return execute(new BizServiceCallBack<RegisterRequest, UserModel, RegisterResult>(
            requestData, transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected UserModel doCallBack(RegisterRequest pamateter) {
                //��װģ��
                UserModel model = userFactory.compose(pamateter);

                //���������
                userDomainService.regist(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected RegisterResult composeResult(UserModel model, Exception e) {
                RegisterResult result = new RegisterResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                    result.setUserId(model.getId());
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("username or email exists already");
                    }
                }
                return result;
            }

        });
    }

    /** 
     * @see com.dnm.facade.api.UserServiceFacade#login(com.dnm.facade.request.LoginRequest)
     */
    @Override
    public LoginResult login(LoginRequest requestData) {
        return execute(new BizServiceCallBack<LoginRequest, UserModel, LoginResult>(requestData,
            null) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected UserModel doCallBack(LoginRequest pamateter) {
                //��װģ��
                UserModel model = userFactory.compose(pamateter);
                //���������
                userDomainService.login(model);
                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected LoginResult composeResult(UserModel model, Exception e) {
                LoginResult result = new LoginResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                    result.setUserId(model.getId());
                } else {
                    ResultHelper.fillFailResult(result, e);
                }
                return result;
            }

        });
    }

}
