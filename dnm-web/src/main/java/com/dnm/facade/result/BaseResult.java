/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.result;

import java.io.Serializable;

import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * ���������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseResult.java, v 0.1 2014-4-13 ����8:26:12 hongmin.zhonghm Exp $
 */
public class BaseResult implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5930697642411394326L;

    /** �Ƿ�ɹ� */
    protected boolean         success          = false;

    /** ���������� */
    protected String          resultCode       = ResultCodeEnum.SYSTEM_ERROR.getCode();

    /** ���������� */
    protected String          resulstMsg       = ResultCodeEnum.SYSTEM_ERROR.getDescription();

    /**
     * Getter �Ƿ�ɹ�
     * 
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter �Ƿ�ɹ�
     * 
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter ����������
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Setter ����������
     * 
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * Getter ����������
     * 
     * @return property value of resulstMsg
     */
    public String getResulstMsg() {
        return resulstMsg;
    }

    /**
     * Setter ����������
     * 
     * @param resulstMsg value to be assigned to property resulstMsg
     */
    public void setResulstMsg(String resulstMsg) {
        this.resulstMsg = resulstMsg;
    }

}
