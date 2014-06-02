/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.exception;

import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * �쳣��Ϣ�������쳣���롢�쳣���������쳣Ϊ����ʱ�쳣��
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmException.java, v 0.1 2014-4-7 ����8:46:14 hongmin.zhonghm Exp $
 */
public class DnmException extends RuntimeException {

    /** serialVersionUID */
    private static final long    serialVersionUID = -2771695357234480766L;

    /** �쳣������� */
    private final ResultCodeEnum resultCode;

    /**
     * �ܸ��쳣Ĭ�Ϲ��췽�����쳣ԭ��δ֪
     * 
     * @see ResultCodeEnum#UNKNOWN_EXCEPTION
     */
    public DnmException() {
        this(ResultCodeEnum.SYSTEM_ERROR);
    }

    /**
     * �ܸ��쳣���췽����ָ���쳣��������
     * 
     * @param resultCode �쳣�����
     */
    public DnmException(ResultCodeEnum resultCode) {
        this(resultCode, resultCode.getDescription());
    }

    /**
     * �ܸ��쳣���췽����ָ���쳣��������
     * 
     * @param msg �쳣����
     * @param resultCode �쳣�����
     */
    public DnmException(ResultCodeEnum resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

    /**
     * �ܸ��쳣���췽�����������쳣��װΪ�ܸ��쳣
     * 
     * @param cause �쳣����ԭ��
     */
    public DnmException(Throwable cause) {
        this(ResultCodeEnum.SYSTEM_ERROR, cause);
    }

    /**
     * �ܸ��쳣���췽�����������쳣��װΪ�ܸ��쳣
     * 
     * @param resultCode �쳣�������
     * @param cause �쳣����ԭ��
     */
    public DnmException(ResultCodeEnum resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    /**
     * ��ȡ�ܸ��쳣�������
     * 
     * @return �쳣�������
     */
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }
}
