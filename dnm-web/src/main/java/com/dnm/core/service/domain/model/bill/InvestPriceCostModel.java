/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 投标相关金额交易日志领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransLogModel.java, v 0.1 2014-5-5 下午1:12:50 hongmin.zhonghm Exp $
 */
public class InvestPriceCostModel extends DomainModel {

    /** id */
    private String     id;

    /** 同一个标的全局ID */
    private String     guid;

    /** 业务ID */
    private String     bizId;

    /** 交易类型 */
    private String     transType;

    /** 子交易类型 */
    private String     transSubType;

    /** 原始交易金额 */
    private BigDecimal origTransAmt;

    /** 交易额比例 */
    private BigDecimal transRate;

    /** 交易金额 */
    private BigDecimal transAmt;

    /** 交易币种 */
    private String     transCurrency;

    /** 备注 */
    private String     memo;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.id is empty");
        AssertUtil.notBlank(guid, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.guid is empty");
        AssertUtil.notBlank(transType, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transType is empty");
        AssertUtil.notBlank(transSubType, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transSubType is empty");
        AssertUtil.isTrue(transAmt.compareTo(new BigDecimal(0)) > 0,
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.transAmt must greater than 0");
        AssertUtil.notBlank(transCurrency, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "AccountTransLogModel.currency is empty");
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>guid</tt>.
     * 
     * @return property value of guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Setter method for property <tt>guid</tt>.
     * 
     * @param guid value to be assigned to property guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * Getter method for property <tt>bizId</tt>.
     * 
     * @return property value of bizId
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * Setter method for property <tt>bizId</tt>.
     * 
     * @param bizId value to be assigned to property bizId
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * Getter method for property <tt>origTransAmt</tt>.
     * 
     * @return property value of origTransAmt
     */
    public BigDecimal getOrigTransAmt() {
        return origTransAmt;
    }

    /**
     * Setter method for property <tt>origTransAmt</tt>.
     * 
     * @param origTransAmt value to be assigned to property origTransAmt
     */
    public void setOrigTransAmt(BigDecimal origTransAmt) {
        this.origTransAmt = origTransAmt;
    }

    /**
     * Getter method for property <tt>transRate</tt>.
     * 
     * @return property value of transRate
     */
    public BigDecimal getTransRate() {
        return transRate;
    }

    /**
     * Setter method for property <tt>transRate</tt>.
     * 
     * @param transRate value to be assigned to property transRate
     */
    public void setTransRate(BigDecimal transRate) {
        this.transRate = transRate;
    }

    /**
     * Getter method for property <tt>transAmt</tt>.
     * 
     * @return property value of transAmt
     */
    public BigDecimal getTransAmt() {
        return transAmt;
    }

    /**
     * Setter method for property <tt>transAmt</tt>.
     * 
     * @param transAmt value to be assigned to property transAmt
     */
    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    /**
     * Getter method for property <tt>transType</tt>.
     * 
     * @return property value of transType
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Setter method for property <tt>transType</tt>.
     * 
     * @param transType value to be assigned to property transType
     */
    public void setTransType(String transType) {
        this.transType = transType;
    }

    /**
     * Getter method for property <tt>transSubType</tt>.
     * 
     * @return property value of transSubType
     */
    public String getTransSubType() {
        return transSubType;
    }

    /**
     * Setter method for property <tt>transSubType</tt>.
     * 
     * @param transSubType value to be assigned to property transSubType
     */
    public void setTransSubType(String transSubType) {
        this.transSubType = transSubType;
    }

    /**
     * Getter method for property <tt>transCurrency</tt>.
     * 
     * @return property value of transCurrency
     */
    public String getTransCurrency() {
        return transCurrency;
    }

    /**
     * Setter method for property <tt>transCurrency</tt>.
     * 
     * @param transCurrency value to be assigned to property transCurrency
     */
    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

}
