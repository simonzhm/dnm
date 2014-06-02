/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.service.domain.PlatformDomainService;
import com.dnm.core.service.domain.factory.PlatformFactory;
import com.dnm.core.service.domain.model.bill.PlatformModel;
import com.dnm.facade.api.PlatformServiceFacade;
import com.dnm.facade.request.AddPlatformRequest;
import com.dnm.facade.request.AddPlatformUsersRequest;
import com.dnm.facade.result.BaseResult;

/**
 * 平台服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankServiceFacadeImpl.java, v 0.1 2014-5-8 上午1:49:59 hongmin.zhonghm Exp $
 */
public class PlatformServiceFacadeImpl extends BizServiceTemplate implements PlatformServiceFacade {
    /** 领域模型工厂 */
    @Resource
    private PlatformFactory       platformFactory;

    /** 领域服务 */
    @Resource
    private PlatformDomainService platformDomainService;

    /** 
     * @see com.dnm.facade.api.PlatformServiceFacade#addPlatform(com.dnm.facade.request.AddPlatformRequest)
     */
    @Override
    public BaseResult addPlatform(AddPlatformRequest requestData) {
        return execute(new BizServiceCallBack<AddPlatformRequest, PlatformModel, BaseResult>(
            requestData, transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected PlatformModel doCallBack(AddPlatformRequest pamateter) {
                //组装模型
                PlatformModel model = platformFactory.compose(pamateter);

                //领域服务处理
                platformDomainService.addPlatform(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected BaseResult composeResult(PlatformModel model, Exception e) {
                BaseResult result = new BaseResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("platform exists already");
                    }
                }
                return result;
            }

        });
    }

    /** 
     * @see com.dnm.facade.api.PlatformServiceFacade#addPlatformUsers(com.dnm.facade.request.AddPlatformUsersRequest)
     */
    @Override
    public BaseResult addPlatformUsers(AddPlatformUsersRequest requestData) {
        return execute(new BizServiceCallBack<AddPlatformUsersRequest, PlatformModel, BaseResult>(
            requestData, transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected PlatformModel doCallBack(AddPlatformUsersRequest pamateter) {
                //组装模型
                PlatformModel model = platformFactory.compose(pamateter);

                //领域服务处理
                platformDomainService.addPlatformUsers(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected BaseResult composeResult(PlatformModel model, Exception e) {
                BaseResult result = new BaseResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("user of this platform exists already");
                    }
                }
                return result;
            }

        });
    }

}
