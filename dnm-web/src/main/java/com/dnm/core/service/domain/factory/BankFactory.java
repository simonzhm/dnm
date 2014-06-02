/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.BankModel;
import com.dnm.facade.request.AddBankRequest;

/**
 * 银行领域模型工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: BankFactory.java, v 0.1 2014-5-5 下午11:38:07 hongmin.zhonghm Exp $
 */
public interface BankFactory {

    /**
     * 组装银行领域模型
     * 
     * @param requestData
     * @return
     */
    public BankModel compose(AddBankRequest requestData);
}
