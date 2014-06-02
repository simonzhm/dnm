/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.facade.api.UserServiceFacade;
import com.dnm.facade.request.LoginRequest;
import com.dnm.facade.result.BaseResult;
import com.dnm.facade.result.LoginResult;

/**
 * 登陆
 * 
 * @author hongmin.zhonghm
 * @version $Id: LoginAction.java, v 0.1 2014-5-2 下午12:15:37 hongmin.zhonghm Exp $
 */
public class LoginAction extends BaseAction {

    /** serialVersionUID */
    private static final long serialVersionUID = 1156456090992167161L;

    /** 用户服务 */
    @Resource
    private UserServiceFacade userServiceFacade;

    /** 请求单据 */
    private LoginRequest      requestData;

    /** 返回结果 */
    private LoginResult       responseData     = new LoginResult();

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        responseData = userServiceFacade.login(requestData);

        if (ResultHelper.isSuccess(responseData)) {
            if (ResultHelper.isSuccess(responseData)) {
                session.put(USER_SESSION_KEY, responseData.getUserId());
            }
        }
    }

    /**
     * Getter method for property <tt>requestData</tt>.
     * 
     * @return property value of requestData
     */
    @JSON(serialize = false)
    public LoginRequest getRequestData() {
        return requestData;
    }

    /**
     * Setter method for property <tt>requestData</tt>.
     * 
     * @param requestData value to be assigned to property requestData
     */
    public void setRequestData(LoginRequest requestData) {
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
