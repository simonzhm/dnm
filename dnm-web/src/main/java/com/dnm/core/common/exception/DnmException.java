/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.exception;

import com.dnm.core.common.resultcode.ResultCodeEnum;

/**
 * 异常信息，包括异常代码、异常描述。此异常为运行时异常。
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmException.java, v 0.1 2014-4-7 下午8:46:14 hongmin.zhonghm Exp $
 */
public class DnmException extends RuntimeException {

    /** serialVersionUID */
    private static final long    serialVersionUID = -2771695357234480766L;

    /** 异常结果代码 */
    private final ResultCodeEnum resultCode;

    /**
     * 拒付异常默认构造方法，异常原因未知
     * 
     * @see ResultCodeEnum#UNKNOWN_EXCEPTION
     */
    public DnmException() {
        this(ResultCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 拒付异常构造方法，指定异常发生代码
     * 
     * @param resultCode 异常结果码
     */
    public DnmException(ResultCodeEnum resultCode) {
        this(resultCode, resultCode.getDescription());
    }

    /**
     * 拒付异常构造方法，指定异常发生代码
     * 
     * @param msg 异常描述
     * @param resultCode 异常结果码
     */
    public DnmException(ResultCodeEnum resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

    /**
     * 拒付异常构造方法。将其他异常包装为拒付异常
     * 
     * @param cause 异常发生原因
     */
    public DnmException(Throwable cause) {
        this(ResultCodeEnum.SYSTEM_ERROR, cause);
    }

    /**
     * 拒付异常构造方法。将其他异常包装为拒付异常
     * 
     * @param resultCode 异常结果代码
     * @param cause 异常发生原因
     */
    public DnmException(ResultCodeEnum resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    /**
     * 获取拒付异常结果代码
     * 
     * @return 异常结果代码
     */
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }
}
