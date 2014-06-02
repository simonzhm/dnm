/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.dnm.facade.api.AccountTransferServiceFacade;
import com.dnm.facade.request.AccountTransferRequest;
import com.dnm.facade.result.BaseResult;

/**
 * �˻����״�����
 * 
 * @author hongmin.zhonghm
 * @version $Id: OpenAccountAction.java.java, v 0.1 2014-5-7 ����12:56:21 hongmin.zhonghm Exp $
 */
public class AccountTransferAction extends BaseAction {

    /** serialVersionUID */
    private static final long            serialVersionUID = -4048083385538030638L;

    /** �˻����׷��� */
    @Resource
    private AccountTransferServiceFacade accountTransferServiceFacade;

    /** ���󵥾� */
    private AccountTransferRequest       requestData;

    /** ���ؽ�� */
    private BaseResult                   responseData     = new BaseResult();

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        responseData = accountTransferServiceFacade.transfer(requestData);
    }

    /**
     * Getter method for property <tt>requestData</tt>.
     * 
     * @return property value of requestData
     */
    @JSON(serialize = false)
    public AccountTransferRequest getRequestData() {
        return requestData;
    }

    /**
     * Setter method for property <tt>requestData</tt>.
     * 
     * @param requestData value to be assigned to property requestData
     */
    public void setRequestData(AccountTransferRequest requestData) {
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
