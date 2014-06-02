/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.facade.api.UserServiceFacade;
import com.dnm.facade.request.RegisterRequest;
import com.dnm.facade.result.BaseResult;
import com.dnm.facade.result.RegisterResult;

/**
 * ע�ᴦ����
 * 
 * <P>
 * ��ע�⣬����ʹ����JSON��ʽ���ؽ��������get�������������أ������ϣ�����صģ�����get�����ϼ���@JSON(serialize = false)
 * </P>
 * @author hongmin.zhonghm
 * @version $Id: RegisterAction.java, v 0.1 2014-4-13 ����2:13:52 hongmin.zhonghm Exp $
 */
public class RegisterAction extends BaseAction {

    /** serialVersionUID */
    private static final long serialVersionUID = 4272863240818034768L;

    /** �û����� */
    @Resource
    private UserServiceFacade userServiceFacade;

    /** ���󵥾� */
    private RegisterRequest   requestData;

    /** ���ؽ�� */
    private RegisterResult    responseData     = new RegisterResult();

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        responseData = userServiceFacade.regist(requestData);
        if (ResultHelper.isSuccess(responseData)) {
            session.put(USER_SESSION_KEY, responseData.getUserId());
        }
    }

    /**
     * Getter method for property <tt>requestData</tt>.
     * 
     * @return property value of requestData
     */
    @JSON(serialize = false)
    public RegisterRequest getRequestData() {
        return requestData;
    }

    /**
     * Setter method for property <tt>requestData</tt>.
     * 
     * @param requestData value to be assigned to property requestData
     */
    public void setRequestData(RegisterRequest requestData) {
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
