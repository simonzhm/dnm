/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.result;

import java.io.Serializable;

import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * 基础结果类
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseResult.java, v 0.1 2014-4-13 下午8:26:12 hongmin.zhonghm Exp $
 */
public class BaseResult implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5930697642411394326L;

    /** 是否成功 */
    protected boolean         success          = false;

    /** 错误结果代码 */
    protected String          resultCode       = ResultCodeEnum.SYSTEM_ERROR.getCode();

    /** 错误结果详情 */
    protected String          resulstMsg       = ResultCodeEnum.SYSTEM_ERROR.getDescription();

    /**
     * Getter 是否成功
     * 
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter 是否成功
     * 
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter 错误结果代码
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Setter 错误结果代码
     * 
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * Getter 错误结果详情
     * 
     * @return property value of resulstMsg
     */
    public String getResulstMsg() {
        return resulstMsg;
    }

    /**
     * Setter 错误结果详情
     * 
     * @param resulstMsg value to be assigned to property resulstMsg
     */
    public void setResulstMsg(String resulstMsg) {
        this.resulstMsg = resulstMsg;
    }

}
