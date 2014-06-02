/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import javax.annotation.Resource;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.facade.api.UserServiceFacade;
import com.dnm.facade.result.BaseResult;

/**
 * 登出
 * 
 * @author hongmin.zhonghm
 * @version $Id: LogoutAction.java, v 0.1 2014-5-4 下午9:45:07 hongmin.zhonghm Exp $
 */
public class LogoutAction extends BaseAction {

    /** serialVersionUID */
    private static final long serialVersionUID = -506228298567711792L;

    /** 用户服务 */
    @Resource
    private UserServiceFacade userServiceFacade;

    /** 返回结果 */
    private BaseResult        responseData     = new BaseResult();

    /** 
     * @see com.dnm.web.action.BaseAction#doExecute()
     */
    @Override
    protected void doExecute() {
        session.remove(USER_SESSION_KEY);
        responseData = ResultHelper.createSuccessResult();
    }

    /** 
     * @see com.dnm.web.action.BaseAction#getResponseData()
     */
    @Override
    public BaseResult getResponseData() {
        return responseData;
    }

}
