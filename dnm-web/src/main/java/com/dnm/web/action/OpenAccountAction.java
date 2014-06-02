/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.dnm.facade.api.AccountServiceFacade;
import com.dnm.facade.request.OpenAccountRequest;
import com.dnm.facade.result.AccountResult;

/**
 * 开户处理类
 * 
 * @author hongmin.zhonghm
 * @version $Id: OpenAccountAction.java, v 0.1 2014-5-7 上午12:56:21 hongmin.zhonghm Exp $
 */
public class OpenAccountAction extends BaseAction {

    /** serialVersionUID */
    private static final long    serialVersionUID = -4048083385538030638L;

    /** 账户服务 */
    @Resource
    private AccountServiceFacade accountServiceFacade;

    /** 请求单据 */
    private OpenAccountRequest   requestData;

    /** 返回结果 */
    private AccountResult    responseData     = new AccountResult();

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        responseData = accountServiceFacade.openAccount(requestData);
    }

    /**
     * Getter method for property <tt>requestData</tt>.
     * 
     * @return property value of requestData
     */
    @JSON(serialize = false)
    public OpenAccountRequest getRequestData() {
        return requestData;
    }

    /**
     * Setter method for property <tt>requestData</tt>.
     * 
     * @param requestData value to be assigned to property requestData
     */
    public void setRequestData(OpenAccountRequest requestData) {
        this.requestData = requestData;
    }

    /**
     * Getter method for property <tt>responseData</tt>.
     * 
     * @return property value of responseData
     */
    public AccountResult getResponseData() {
        return responseData;
    }

}
