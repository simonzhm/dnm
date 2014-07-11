/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 投标拆分记录领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordModel.java, v 0.1 2014-5-13 上午1:38:37 hongmin.zhonghm Exp $
 */
public class InvestDueinRecordModel extends DomainModel {

    /** ID */
    private String     id;

    /** 投标记录ID */
    private String     investRecordId;

    /** 还款序列 */
    private int        periodIndex;

    /** 还款金额 */
    private BigDecimal repayAmt;

    /** 还款利息 */
    private BigDecimal repayInterestAmt;

    /** 还款日期 */
    private String     repayDate;

    /** 实际还款日期 */
    private String     actualRepayDate;

    /** 是否逾期(Y,N)*/
    private String     isDelay;

    /** 是否回款(Y,N) */
    private String     isFinish;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestDueinRecordModel.id is empty");
        AssertUtil.notBlank(investRecordId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestDueinRecordModel.investRecordId is empty");
        AssertUtil.isTrue(periodIndex > 0, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestDueinRecordModel.periodIndex must greater than 0");
        AssertUtil.notNull(repayAmt, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestDueinRecordModel.repayAmt is null");
        AssertUtil.isTrue(repayAmt.compareTo(new BigDecimal(0)) > 0,
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestDueinRecordModel.repayAmt must greater than 0");
        AssertUtil.isTrue(StringUtil.isMeetLength(repayDate, 8),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestDueinRecordModel.repayDate is illegal");
        if(!StringUtil.isEmpty(actualRepayDate)){
	        AssertUtil.isTrue(StringUtil.isMeetLength(actualRepayDate, 8),
	            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
	            "InvestDueinRecordModel.actualRepayDate is illegal");
        }
        AssertUtil.isTrue(StringUtil.isMeetLength(isDelay, 1),
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "InvestDueinRecordModel.isDelay is illegal");
        AssertUtil
            .isTrue(StringUtil.isMeetLength(isFinish, 1),
                ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
                "InvestDueinRecordModel.isFinish is illegal");
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
     * Getter method for property <tt>investRecordId</tt>.
     * 
     * @return property value of investRecordId
     */
    public String getInvestRecordId() {
        return investRecordId;
    }

    /**
     * Setter method for property <tt>investRecordId</tt>.
     * 
     * @param investRecordId value to be assigned to property investRecordId
     */
    public void setInvestRecordId(String investRecordId) {
        this.investRecordId = investRecordId;
    }

    /**
     * Getter method for property <tt>periodIndex</tt>.
     * 
     * @return property value of periodIndex
     */
    public int getPeriodIndex() {
        return periodIndex;
    }

    /**
     * Setter method for property <tt>periodIndex</tt>.
     * 
     * @param periodIndex value to be assigned to property periodIndex
     */
    public void setPeriodIndex(int periodIndex) {
        this.periodIndex = periodIndex;
    }

    /**
     * Getter method for property <tt>repayAmt</tt>.
     * 
     * @return property value of repayAmt
     */
    public BigDecimal getRepayAmt() {
        return repayAmt;
    }

    /**
     * Setter method for property <tt>repayAmt</tt>.
     * 
     * @param repayAmt value to be assigned to property repayAmt
     */
    public void setRepayAmt(BigDecimal repayAmt) {
        this.repayAmt = repayAmt;
    }

    /**
     * Getter method for property <tt>repayInterestAmt</tt>.
     * 
     * @return property value of repayInterestAmt
     */
    public BigDecimal getRepayInterestAmt() {
        return repayInterestAmt;
    }

    /**
     * Setter method for property <tt>repayInterestAmt</tt>.
     * 
     * @param repayInterestAmt value to be assigned to property repayInterestAmt
     */
    public void setRepayInterestAmt(BigDecimal repayInterestAmt) {
        this.repayInterestAmt = repayInterestAmt;
    }

    /**
     * Getter method for property <tt>repayDate</tt>.
     * 
     * @return property value of repayDate
     */
    public String getRepayDate() {
        return repayDate;
    }

    /**
     * Setter method for property <tt>repayDate</tt>.
     * 
     * @param repayDate value to be assigned to property repayDate
     */
    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    /**
     * Getter method for property <tt>actualRepayDate</tt>.
     * 
     * @return property value of actualRepayDate
     */
    public String getActualRepayDate() {
        return actualRepayDate;
    }

    /**
     * Setter method for property <tt>actualRepayDate</tt>.
     * 
     * @param actualRepayDate value to be assigned to property actualRepayDate
     */
    public void setActualRepayDate(String actualRepayDate) {
        this.actualRepayDate = actualRepayDate;
    }

    /**
     * Getter method for property <tt>isDelay</tt>.
     * 
     * @return property value of isDelay
     */
    public String getIsDelay() {
        return isDelay;
    }

    /**
     * Setter method for property <tt>isDelay</tt>.
     * 
     * @param isDelay value to be assigned to property isDelay
     */
    public void setIsDelay(String isDelay) {
        this.isDelay = isDelay;
    }

    /**
     * Getter method for property <tt>isFinish</tt>.
     * 
     * @return property value of isFinish
     */
    public String getIsFinish() {
        return isFinish;
    }

    /**
     * Setter method for property <tt>isFinish</tt>.
     * 
     * @param isFinish value to be assigned to property isFinish
     */
    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

}
