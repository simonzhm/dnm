/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import java.lang.reflect.Field;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.dnm.biz.helper.ResultHelper;
import com.dnm.core.cache.RequestOrderCache;
import com.dnm.core.common.util.ReflectionUtil;
import com.dnm.facade.request.BaseSessionRequestOrder;
import com.dnm.facade.result.BaseResult;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action基类
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseAction.java, v 0.1 2014-4-7 下午6:05:36 hongmin.zhonghm Exp $
 */
public abstract class BaseAction extends ActionSupport implements SessionAware {

    /** serialVersionUID */
    private static final long     serialVersionUID = -8851029432404000988L;

    /** 日志 */
    protected static final Logger LOGGER           = Logger.getLogger(BaseAction.class);

    /** user session key  */
    public static final String    USER_SESSION_KEY = "USER_SESSION_KEY";

    /** json结果串  */
    protected static final String JSON_RESULT      = "jsonResult";

    /** web sessgion */
    protected Map<String, Object> session;
    
    /** 请求单据缓存 */
    @Resource
    private RequestOrderCache requestOrderCache;

    /** 
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public String execute() throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute " + ReflectionUtil.getSimpleName(this));
        }
        Field f = requestOrderCache.getRequestOrderField(ReflectionUtil.getFullName(this));
        if(f != null){
	        Object request = ReflectionUtil.getFieldValue(this, f);
	        //如果属于带session的请求单据，则自动给userId赋值，前面的session校验拦截器能保证这里的session不会为空，
	        if (request != null && request instanceof BaseSessionRequestOrder) {
	            ((BaseSessionRequestOrder) request).setUserId(session.get(USER_SESSION_KEY).toString());
	        }
        }

        BaseResult result = getResponseData();
        try {
            doExecute();
        } catch (Exception e) {
            LOGGER.error("[" + ReflectionUtil.getSimpleName(this) + "] execute fail.", e);
            ResultHelper.fillFailResult(result, e);
        }

        return JSON_RESULT;
    }

    /**
     * 逻辑处理
     */
    abstract protected void doExecute();


    /**
     * 获取结果
     * 
     * @return
     */
    abstract public BaseResult getResponseData();

    /** 
     * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
     */
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
