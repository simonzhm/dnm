/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.helper;

import org.springframework.dao.DuplicateKeyException;

import com.dnm.core.common.exception.DnmException;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.StringUtil;
import com.dnm.facade.result.BaseResult;

/**
 * ������������
 * 
 * @author hongmin.zhonghm
 * @version $Id: ResultHelper.java, v 0.1 2014-4-13 ����8:24:56 hongmin.zhonghm Exp $
 */
public class ResultHelper {

    /**
     * �����ɹ����
     * 
     * @return
     */
    public static BaseResult createSuccessResult() {
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        result.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        result.setResulstMsg(ResultCodeEnum.SUCCESS.getDescription());
        return result;
    }

    /**
     * ���ɹ����
     * 
     * @param result
     */
    public static void fillSuccessResult(BaseResult result) {
        result.setSuccess(true);
        result.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        result.setResulstMsg(ResultCodeEnum.SUCCESS.getDescription());
    }

    /**
     * ���ʧ�ܽ��
     * 
     * @param result
     */
    public static void fillFailResult(BaseResult result) {
        fillFailResult(result, null);
    }

    /**
     * ���ʧ�ܽ��
     * 
     * @param result
     * @param e
     */
    public static void fillFailResult(BaseResult result, Exception e) {
        fillFailResult(result, e, null);
    }

    /**
     * ���ʧ�ܽ��
     * 
     * @param result
     * @param e
     * @param msg
     */
    public static void fillFailResult(BaseResult result, Exception e, String msg) {
        result.setSuccess(false);
        if (e != null && e instanceof DnmException) {
            DnmException de = (DnmException) e;
            result.setResultCode(de.getResultCode().getCode());
            result.setResulstMsg(de.getResultCode().getDescription() + ":" + de.getMessage());
        } else if (e instanceof DuplicateKeyException) {
            result.setResultCode(ResultCodeEnum.DUPLICATE_KEY.getCode());
            result.setResulstMsg(StringUtil.isBlank(msg) ? e.getMessage() : msg);
        } else {
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResulstMsg(ResultCodeEnum.SYSTEM_ERROR.getDescription());
        }
    }

    /**
     * ���ؽ���Ƿ�ɹ�
     * 
     * @param result
     * @return
     */
    public static boolean isSuccess(BaseResult result) {
        return result == null ? false : result.isSuccess();
    }

    /**
     * ���ؽ���Ƿ�ΨһԼ���쳣
     * 
     * @param result
     * @return
     */
    public static boolean isDuplicate(BaseResult result) {
        return result == null ? false : StringUtil.equals(result.getResultCode(),
            ResultCodeEnum.DUPLICATE_KEY.getCode());
    }
}
