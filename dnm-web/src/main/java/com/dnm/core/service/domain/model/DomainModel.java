/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model;

import java.util.Date;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;

/**
 * ����ģ�ͽӿ�
 * @author hongmin.zhonghm
 * @version $Id: DomainModel.java, v 0.1 2014-4-13 ����12:42:30 hongmin.zhonghm Exp $
 */
public abstract class DomainModel {

    /** ����ʱ�� */
    protected Date gmtCreate;

    /** �޸�ʱ�� */
    protected Date gmtModified;

    /**
     * ģ��һ���Լ�顣
     *
     * <p>�ִ����ء��־û�����Ҫ���ô˷�����֤ģ��һ���ԡ�
     */
    public void checkConsistency() {
        AssertUtil.notNull(gmtCreate, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "gmtCreate is null");
        AssertUtil.notNull(gmtModified, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "gmtModified is nul");

        // ���������Լ��
        dataIntegrityCheck();

        // ���У��
        amountBalanceCheck();
    }

    /**
     * ���������Լ�飬���ģ������ʱ��������Ч
     */
    abstract protected void dataIntegrityCheck();

    /**
     * ���ƽ���飬���ģ�ͽ���Ƿ�ƽ�⡢��Ч
     */
    protected void amountBalanceCheck() {

    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModified</tt>.
     * 
     * @return property value of gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * Setter method for property <tt>gmtModified</tt>.
     * 
     * @param gmtModified value to be assigned to property gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
