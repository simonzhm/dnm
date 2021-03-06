/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.dnm.facade.api.BankServiceFacade;
import com.dnm.facade.request.AddBankRequest;
import com.dnm.facade.result.BaseResult;

/**
 * 添加银行处理类
 * 
 * @author hongmin.zhonghm
 * @version $Id: OpenAccountAction.java, v 0.1 2014-5-7 上午12:56:21 hongmin.zhonghm Exp $
 */
public class AddBankAction extends BaseAction {

    /** serialVersionUID */
    private static final long serialVersionUID = -4048083385538030638L;

    /** 账户服务 */
    @Resource
    private BankServiceFacade bankServiceFacade;

    /** 请求单据 */
    private AddBankRequest    requestData;

    /** 返回结果 */
    private BaseResult        responseData     = new BaseResult();

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        responseData = bankServiceFacade.addBank(requestData);
    }

    /**
     * Getter method for property <tt>requestData</tt>.
     * 
     * @return property value of requestData
     */
    @JSON(serialize = false)
    public AddBankRequest getRequestData() {
        return requestData;
    }

    /**
     * Setter method for property <tt>requestData</tt>.
     * 
     * @param requestData value to be assigned to property requestData
     */
    public void setRequestData(AddBankRequest requestData) {
        this.requestData = requestData;
    }

    /**
     * Getter method for property <tt>responseData</tt>.
     * 
     * @return property value of responseData
     */
    public BaseResult getResponseData() {
        return responseData;
    }

}
