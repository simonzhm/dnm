/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model.bill;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.domain.model.DomainModel;

/**
 * 投标记录领域模型
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordModel.java, v 0.1 2014-5-13 上午1:38:37 hongmin.zhonghm Exp $
 */
public class InvestRecordModel extends DomainModel {

    /** ID */
    private String                       id;

    /** 投资平台用户 */
    private String                       platformUserId;

    /** 期限 */
    private int                          period;

    /** 期限类型（年，月，天） */
    private String                       periodType;

    /** 还款方式（A:一次性还款，B:等额本息，C:等额本金，D:按月付息到期还本） */
    private String                       repayMethod;

    /** 投标金额 */
    private BigDecimal                   investAmt;

    /** 投标日期 */
    private String                       investDate;

    /** 利率类型（年，天） */
    private String                       interestRateType;

    /** 利率 */
    private BigDecimal                   interestRate;

    /** 投标利息 */
    private BigDecimal                   interestAmt;

    /** 奖励比例 */
    private BigDecimal                   costAmt;

    /** 奖励金额 */
    private BigDecimal                   priceAmt;

    /** 名义手续费 */
    private BigDecimal                   feeRate;

    /** 是否回款完毕（Y,N) */
    private String                       isFinish;

    /** 备注 */
    private String                       remark;

    /** 平台用户模型 */
    private PlatformUserModel            platformUserModel;

    /** 资金来源账户模型列表 */
    private List<InvestFromAccountModel> invstFromAccountModels;

    /** 投标拆分记录 */
    private List<InvestDueinRecordModel> investDueinRecordModels;

    /** 新增奖励费用记录 */
    private List<InvestPriceCostModel>   newInvestPriceCostModels;

    /** 历史奖励费用记录 */
    private List<InvestPriceCostModel>   hisInvestPriceCostModels;

    /** 
     * @see com.dnm.core.service.domain.model.DomainModel#dataIntegrityCheck()
     */
    @Override
    protected void dataIntegrityCheck() {
        AssertUtil.notBlank(id, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.id is empty");
        AssertUtil.notBlank(platformUserId, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.platformUserId is empty");
        AssertUtil.isTrue(period > 0, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.period must grater than 0");
        AssertUtil.notBlank(repayMethod, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.repayMethod is empty");
        AssertUtil.isTrue(investAmt.compareTo(new BigDecimal(0)) > 0,
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL, "InvestRecordModel.repayMethod is empty");
        AssertUtil.notBlank(investDate, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.investDate is empty");
        AssertUtil.isTrue(investDate.length() == 8, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "length of InvestRecordModel.investDate is illagel,expect 8");
        AssertUtil.notBlank(isFinish, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.isFinish is empty");
        AssertUtil.isTrue(isFinish.length() == 1, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "length of InvestRecordModel.isFinish is illagel,expect 1");

        AssertUtil.notNull(platformUserModel, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.platformUserModel is null");

        AssertUtil.notNull(investDueinRecordModels, ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.investDueinRecordModels is null");
        AssertUtil.isTrue(investDueinRecordModels.size() > 0,
            ResultCodeEnum.MODEL_INTEGRITY_CHECK_FAIL,
            "InvestRecordModel.investDueinRecordModels is empty");
        for (InvestDueinRecordModel investDueinRecordModel : investDueinRecordModels) {
            investDueinRecordModel.checkConsistency();
        }

        if (!CollectionUtils.isEmpty(newInvestPriceCostModels)) {
            for (InvestPriceCostModel investPriceCostModel : newInvestPriceCostModels) {
                investPriceCostModel.checkConsistency();
            }
        }
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
     * Getter method for property <tt>platformUserId</tt>.
     * 
     * @return property value of platformUserId
     */
    public String getPlatformUserId() {
        return platformUserId;
    }

    /**
     * Setter method for property <tt>platformUserId</tt>.
     * 
     * @param platformUserId value to be assigned to property platformUserId
     */
    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId;
    }

    /**
     * Getter method for property <tt>period</tt>.
     * 
     * @return property value of period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Setter method for property <tt>period</tt>.
     * 
     * @param period value to be assigned to property period
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * Getter method for property <tt>periodType</tt>.
     * 
     * @return property value of periodType
     */
    public String getPeriodType() {
        return periodType;
    }

    /**
     * Setter method for property <tt>periodType</tt>.
     * 
     * @param periodType value to be assigned to property periodType
     */
    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    /**
     * Getter method for property <tt>repayMethod</tt>.
     * 
     * @return property value of repayMethod
     */
    public String getRepayMethod() {
        return repayMethod;
    }

    /**
     * Setter method for property <tt>repayMethod</tt>.
     * 
     * @param repayMethod value to be assigned to property repayMethod
     */
    public void setRepayMethod(String repayMethod) {
        this.repayMethod = repayMethod;
    }

    /**
     * Getter method for property <tt>investAmt</tt>.
     * 
     * @return property value of investAmt
     */
    public BigDecimal getInvestAmt() {
        return investAmt;
    }

    /**
     * Setter method for property <tt>investAmt</tt>.
     * 
     * @param investAmt value to be assigned to property investAmt
     */
    public void setInvestAmt(BigDecimal investAmt) {
        this.investAmt = investAmt;
    }

    /**
     * Getter method for property <tt>investDate</tt>.
     * 
     * @return property value of investDate
     */
    public String getInvestDate() {
        return investDate;
    }

    /**
     * Setter method for property <tt>investDate</tt>.
     * 
     * @param investDate value to be assigned to property investDate
     */
    public void setInvestDate(String investDate) {
        this.investDate = investDate;
    }

    /**
     * Getter method for property <tt>interestRateType</tt>.
     * 
     * @return property value of interestRateType
     */
    public String getInterestRateType() {
        return interestRateType;
    }

    /**
     * Setter method for property <tt>interestRateType</tt>.
     * 
     * @param interestRateType value to be assigned to property interestRateType
     */
    public void setInterestRateType(String interestRateType) {
        this.interestRateType = interestRateType;
    }

    /**
     * Getter method for property <tt>interestRate</tt>.
     * 
     * @return property value of interestRate
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Setter method for property <tt>interestRate</tt>.
     * 
     * @param interestRate value to be assigned to property interestRate
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Getter method for property <tt>interestAmt</tt>.
     * 
     * @return property value of interestAmt
     */
    public BigDecimal getInterestAmt() {
        return interestAmt;
    }

    /**
     * Setter method for property <tt>interestAmt</tt>.
     * 
     * @param interestAmt value to be assigned to property interestAmt
     */
    public void setInterestAmt(BigDecimal interestAmt) {
        this.interestAmt = interestAmt;
    }

    /**
     * Getter method for property <tt>costAmt</tt>.
     * 
     * @return property value of costAmt
     */
    public BigDecimal getCostAmt() {
        return costAmt;
    }

    /**
     * Setter method for property <tt>costAmt</tt>.
     * 
     * @param costAmt value to be assigned to property costAmt
     */
    public void setCostAmt(BigDecimal costAmt) {
        this.costAmt = costAmt;
    }

    /**
     * Getter method for property <tt>priceAmt</tt>.
     * 
     * @return property value of priceAmt
     */
    public BigDecimal getPriceAmt() {
        return priceAmt;
    }

    /**
     * Setter method for property <tt>priceAmt</tt>.
     * 
     * @param priceAmt value to be assigned to property priceAmt
     */
    public void setPriceAmt(BigDecimal priceAmt) {
        this.priceAmt = priceAmt;
    }

    /**
     * Getter method for property <tt>feeRate</tt>.
     * 
     * @return property value of feeRate
     */
    public BigDecimal getFeeRate() {
        return feeRate;
    }

    /**
     * Setter method for property <tt>feeRate</tt>.
     * 
     * @param feeRate value to be assigned to property feeRate
     */
    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
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

    /**
     * Getter method for property <tt>remark</tt>.
     * 
     * @return property value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property <tt>remark</tt>.
     * 
     * @param remark value to be assigned to property remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Getter method for property <tt>platformUserModel</tt>.
     * 
     * @return property value of platformUserModel
     */
    public PlatformUserModel getPlatformUserModel() {
        return platformUserModel;
    }

    /**
     * Setter method for property <tt>platformUserModel</tt>.
     * 
     * @param platformUserModel value to be assigned to property platformUserModel
     */
    public void setPlatformUserModel(PlatformUserModel platformUserModel) {
        this.platformUserModel = platformUserModel;
    }

    /**
     * Getter method for property <tt>invstFromAccountModels</tt>.
     * 
     * @return property value of invstFromAccountModels
     */
    public List<InvestFromAccountModel> getInvstFromAccountModels() {
        return invstFromAccountModels;
    }

    /**
     * Setter method for property <tt>invstFromAccountModels</tt>.
     * 
     * @param invstFromAccountModels value to be assigned to property invstFromAccountModels
     */
    public void setInvstFromAccountModels(List<InvestFromAccountModel> invstFromAccountModels) {
        this.invstFromAccountModels = invstFromAccountModels;
    }

    /**
     * Getter method for property <tt>investDueinRecordModels</tt>.
     * 
     * @return property value of investDueinRecordModels
     */
    public List<InvestDueinRecordModel> getInvestDueinRecordModels() {
        return investDueinRecordModels;
    }

    /**
     * Setter method for property <tt>investDueinRecordModels</tt>.
     * 
     * @param investDueinRecordModels value to be assigned to property investDueinRecordModels
     */
    public void setInvestDueinRecordModels(List<InvestDueinRecordModel> investDueinRecordModels) {
        this.investDueinRecordModels = investDueinRecordModels;
    }

    /**
     * Getter method for property <tt>newInvestPriceCostModels</tt>.
     * 
     * @return property value of newInvestPriceCostModels
     */
    public List<InvestPriceCostModel> getNewInvestPriceCostModels() {
        return newInvestPriceCostModels;
    }

    /**
     * Setter method for property <tt>newInvestPriceCostModels</tt>.
     * 
     * @param newInvestPriceCostModels value to be assigned to property newInvestPriceCostModels
     */
    public void setNewInvestPriceCostModels(List<InvestPriceCostModel> newInvestPriceCostModels) {
        this.newInvestPriceCostModels = newInvestPriceCostModels;
    }

    /**
     * Getter method for property <tt>hisInvestPriceCostModels</tt>.
     * 
     * @return property value of hisInvestPriceCostModels
     */
    public List<InvestPriceCostModel> getHisInvestPriceCostModels() {
        return hisInvestPriceCostModels;
    }

    /**
     * Setter method for property <tt>hisInvestPriceCostModels</tt>.
     * 
     * @param hisInvestPriceCostModels value to be assigned to property hisInvestPriceCostModels
     */
    public void setHisInvestPriceCostModels(List<InvestPriceCostModel> hisInvestPriceCostModels) {
        this.hisInvestPriceCostModels = hisInvestPriceCostModels;
    }

}
