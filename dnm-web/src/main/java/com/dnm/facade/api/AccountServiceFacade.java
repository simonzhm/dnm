/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.api;

import com.dnm.facade.anotation.FacadeApi;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.request.QueryAccountByUserIdTypeRequest;
import com.dnm.facade.request.QueryAccountRequest;
import com.dnm.facade.result.AccountResult;

/**
 * 账户服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountServiceFacade.java, v 0.1 2014-5-5 上午10:44:25 hongmin.zhonghm Exp $
 */
@FacadeApi
public interface AccountServiceFacade {

    /**
     * 开户
     * 
     * @param requestData
     * @return 账户
     */
    public AccountResult openAccount(OpenAccountRequest requestData);

    /**
     * 查询账户
     * 
     * @param requestData
     * @return 账户
     */
    public AccountResult queryAccount(QueryAccountRequest requestData);

    /**
     * 根据userId和子账户类型查询账户
     * 
     * @param requestData
     * @return 账户
     */
    public AccountResult queryAccountByUserIdType(QueryAccountByUserIdTypeRequest requestData);
}
