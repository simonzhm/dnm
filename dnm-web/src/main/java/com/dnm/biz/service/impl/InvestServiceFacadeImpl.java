/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.service.domain.InvestDomainService;
import com.dnm.core.service.domain.factory.InvestRecordFactory;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.facade.api.InvestServiceFacade;
import com.dnm.facade.request.InvestRequest;
import com.dnm.facade.result.BaseResult;
import com.dnm.facade.result.RegisterResult;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestServiceFacadeImpl.java, v 0.1 2014-5-25 下午6:23:07 hongmin.zhonghm Exp $
 */
public class InvestServiceFacadeImpl extends BizServiceTemplate implements InvestServiceFacade {

    /** 投标领域模型工厂 */
    @Resource
    private InvestRecordFactory investRecordFactory;

    /** 投标领域模型服务 */
    @Resource
    private InvestDomainService InvestDomainService;

    /** 
     * @see com.dnm.facade.api.InvestServiceFacade#invest(com.dnm.facade.request.InvestRequest)
     */
    @Override
    public BaseResult invest(InvestRequest requestdata) {
        return execute(new BizServiceCallBack<InvestRequest, InvestRecordModel, BaseResult>(
            requestdata, transactionTemplate) {

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#doCallBack(java.lang.Object)
             */
            @Override
            protected InvestRecordModel doCallBack(InvestRequest pamateter) {
                //组装模型
                InvestRecordModel model = investRecordFactory.compose(pamateter);

                //领域服务处理
                InvestDomainService.invest(model);

                return model;
            }

            /** 
             * @see com.dnm.biz.service.impl.BizServiceCallBack#composeResult(java.lang.Object, java.lang.Exception)
             */
            @Override
            protected BaseResult composeResult(InvestRecordModel model, Exception e) {
                RegisterResult result = new RegisterResult();
                if (e == null) {
                    ResultHelper.fillSuccessResult(result);
                    result.setUserId(model.getId());
                } else {
                    ResultHelper.fillFailResult(result, e);
                    if (ResultHelper.isDuplicate(result)) {
                        result.setResulstMsg("invest record exists already");
                    }
                }
                return result;
            }

        });
    }

}
