/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import com.dnm.facade.api.InvestServiceFacade;
import com.dnm.facade.request.InvestRequest;
import com.dnm.facade.result.BaseResult;

/**
 * 投标处理器
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestActioin.java, v 0.1 2014-4-7 下午6:06:59 hongmin.zhonghm Exp $
 */
public class InvestAction extends BaseAction {

    /** serialVersionUID */
    private static final long   serialVersionUID = 2527882721574586848L;

    /** 投标服务 */
    @Resource
    private InvestServiceFacade investServiceFacade;

    /** 请求参数 */
    private InvestRequest       requestData;

    /** 返回结果 */
    private BaseResult          responseData     = new BaseResult();     ;

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        responseData = investServiceFacade.invest(requestData);
    }

    /**
     * Getter method for property <tt>requestData</tt>.
     * 
     * @return property value of requestData
     */
    public InvestRequest getRequestData() {
        return requestData;
    }

    /**
     * Setter method for property <tt>requestData</tt>.
     * 
     * @param requestData value to be assigned to property requestData
     */
    public void setRequestData(InvestRequest requestData) {
        this.requestData = requestData;
    }

    /**
     * Setter method for property <tt>responseData</tt>.
     * 
     * @param responseData value to be assigned to property responseData
     */
    public void setResponseData(BaseResult responseData) {
        this.responseData = responseData;
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
