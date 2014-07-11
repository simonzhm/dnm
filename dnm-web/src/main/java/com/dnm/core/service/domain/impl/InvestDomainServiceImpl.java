/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import javax.annotation.Resource;

import com.dnm.core.processor.split.SplitProcessorFactory;
import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.InvestDomainService;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * 投标领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestDomainServiceImpl.java, v 0.1 2014-5-25 下午6:50:09 hongmin.zhonghm Exp $
 */
public class InvestDomainServiceImpl extends AbstractDomainService implements InvestDomainService {

    /** 拆标工厂 */
    @Resource
    protected SplitProcessorFactory splitProcessorFactory;

    /** 
     * @see com.dnm.core.service.domain.InvestDomainService#invest(com.dnm.core.service.domain.model.bill.InvestRecordModel)
     */
    @Override
    public void invest(InvestRecordModel model) {
        //拆标并记账
        split(model);
    }

    /**
     * 拆标并记账
     * 
     * @param model
     */
    private void split(InvestRecordModel model) {
        splitProcessorFactory.getProcessor(model.getRepayMethod()).split(model);
    }
}
