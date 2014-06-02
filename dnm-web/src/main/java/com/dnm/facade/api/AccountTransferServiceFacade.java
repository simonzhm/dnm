/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.request.AccountTransferRequest;
import com.dnm.facade.result.BaseResult;

/**
 * 账户交易接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferServiceFacade.java, v 0.1 2014-5-15 上午1:29:43 hongmin.zhonghm Exp $
 */
public interface AccountTransferServiceFacade {

    /**
     * 账户转账
     * 
     * @param requestData
     * @return
     */
    public BaseResult transfer(AccountTransferRequest requestData);
}
