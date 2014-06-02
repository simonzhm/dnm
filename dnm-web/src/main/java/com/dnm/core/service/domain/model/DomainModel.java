/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model;

import java.util.Date;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;

/**
 * 领域模型接口
 * @author hongmin.zhonghm
 * @version $Id: DomainModel.java, v 0.1 2014-4-13 上午12:42:30 hongmin.zhonghm Exp $
 */
public abstract class DomainModel {

    /** 创建时间 */
    protected Date gmtCreate;

    /** 修改时间 */
    protected Date gmtModified;

    /**
     * 模型一致性检查。
     *
     * <p>仓储加载、持久化都需要调用此方法保证模型一致性。
     */
    public void checkConsistency() {
        AssertUtil.notNull(gmtCreate, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "gmtCreate is null");
        AssertUtil.notNull(gmtModified, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "gmtModified is nul");

        // 数据完整性检查
        dataIntegrityCheck();

        // 金额校验
        amountBalanceCheck();
    }

    /**
     * 数据完整性检查，检查模型数据时否完整有效
     */
    abstract protected void dataIntegrityCheck();

    /**
     * 金额平衡检查，检查模型金额是否平衡、有效
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
