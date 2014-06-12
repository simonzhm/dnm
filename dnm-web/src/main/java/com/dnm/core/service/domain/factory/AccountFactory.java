/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.AccountModel;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.request.QueryAccountByUserIdTypeRequest;
import com.dnm.facade.request.QueryAccountRequest;

/**
 * 账户领域模型工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountFactory.java, v 0.1 2014-5-5 下午11:38:07 hongmin.zhonghm Exp $
 */
public interface AccountFactory {

    /**
     * 组装账户领域模型
     * 
     * @param requestData
     * @return
     */
    public AccountModel compose(OpenAccountRequest requestData);

    /**
     * 组装账户领域模型
     * 
     * @param requestData
     * @return
     */
    public AccountModel compose(QueryAccountRequest requestData);

    /**
     * 组装账户领域模型
     * 
     * @param requestData
     * @return
     */
    public AccountModel compose(QueryAccountByUserIdTypeRequest requestData);
}
