/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import java.util.ArrayList;
import java.util.List;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * Ͷ���¼���󵥾� 
 * @see BaseRequestOrder
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRequest.java, v 0.1 2014-4-7 ����5:14:33 hongmin.zhonghm Exp $
 */
public final class InvestRequest extends BaseSessionRequestOrder {

    /** serialVersionUID */
    private static final long            serialVersionUID = -2673449503705890251L;

    /** ƽ̨�˻�ID */
    @RequestFieldCheck(notEmpty = true)
    private String                       platformUserId;

    /** ���� */
    @RequestFieldCheck(notEmpty = true)
    private String                       period;

    /** �������ͣ��꣬�£��죩*/
    @RequestFieldCheck(notEmpty = true)
    private String                       periodType;

    /** ���ʽ��A:һ���Ի��B:�ȶϢ��C:�ȶ��D:���¸�Ϣ���ڻ�����*/
    @RequestFieldCheck(notEmpty = true)
    private String                       repaymentMethod;

    /** Ͷ����*/
    @RequestFieldCheck(notEmpty = true)
    private String                       investAmt;

    /** Ͷ������*/
    @RequestFieldCheck(notEmpty = true)
    private String                       investDate;

    /** ����*/
    @RequestFieldCheck(notEmpty = true)
    private String                       interestRate;

    /** �������ͣ��꣬�죩*/
    @RequestFieldCheck(notEmpty = true)
    private String                       interestRateType;

    /** ���������� */
    private String                       feeRate;

    /** �Ƿ�ؿ����*/
    @RequestFieldCheck(notEmpty = true)
    private String                       isFinish;

    /** Ͷ�꽱�������б� */
    private List<InvestPriceCostRequest> investPriceList  = new ArrayList<InvestPriceCostRequest>();

    /** Ͷ������б� */
    private List<InvestPriceCostRequest> investCostList   = new ArrayList<InvestPriceCostRequest>();

    /** �����Դ�˻��б� */
    private List<FromAccountRequest>     fromAccountList  = new ArrayList<FromAccountRequest>();

    /** ��ע*/
    private String                       remark;

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
    public String getPeriod() {
        return period;
    }

    /**
     * Setter method for property <tt>period</tt>.
     * 
     * @param period value to be assigned to property period
     */
    public void setPeriod(String period) {
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
     * Getter method for property <tt>repaymentMethod</tt>.
     * 
     * @return property value of repaymentMethod
     */
    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    /**
     * Setter method for property <tt>repaymentMethod</tt>.
     * 
     * @param repaymentMethod value to be assigned to property repaymentMethod
     */
    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    /**
     * Getter method for property <tt>investAmt</tt>.
     * 
     * @return property value of investAmt
     */
    public String getInvestAmt() {
        return investAmt;
    }

    /**
     * Setter method for property <tt>investAmt</tt>.
     * 
     * @param investAmt value to be assigned to property investAmt
     */
    public void setInvestAmt(String investAmt) {
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
     * Getter method for property <tt>interestRate</tt>.
     * 
     * @return property value of interestRate
     */
    public String getInterestRate() {
        return interestRate;
    }

    /**
     * Setter method for property <tt>interestRate</tt>.
     * 
     * @param interestRate value to be assigned to property interestRate
     */
    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
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
     * Getter method for property <tt>feeRate</tt>.
     * 
     * @return property value of feeRate
     */
    public String getFeeRate() {
        return feeRate;
    }

    /**
     * Setter method for property <tt>feeRate</tt>.
     * 
     * @param feeRate value to be assigned to property feeRate
     */
    public void setFeeRate(String feeRate) {
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
     * Getter method for property <tt>investPriceList</tt>.
     * 
     * @return property value of investPriceList
     */
    public List<InvestPriceCostRequest> getInvestPriceList() {
        return investPriceList;
    }

    /**
     * Setter method for property <tt>investPriceList</tt>.
     * 
     * @param investPriceList value to be assigned to property investPriceList
     */
    public void setInvestPriceList(List<InvestPriceCostRequest> investPriceList) {
        this.investPriceList = investPriceList;
    }

    /**
     * Getter method for property <tt>investCostList</tt>.
     * 
     * @return property value of investCostList
     */
    public List<InvestPriceCostRequest> getInvestCostList() {
        return investCostList;
    }

    /**
     * Setter method for property <tt>investCostList</tt>.
     * 
     * @param investCostList value to be assigned to property investCostList
     */
    public void setInvestCostList(List<InvestPriceCostRequest> investCostList) {
        this.investCostList = investCostList;
    }

    /**
     * Getter method for property <tt>fromAccountList</tt>.
     * 
     * @return property value of fromAccountList
     */
    public List<FromAccountRequest> getFromAccountList() {
        return fromAccountList;
    }

    /**
     * Setter method for property <tt>fromAccountList</tt>.
     * 
     * @param fromAccountList value to be assigned to property fromAccountList
     */
    public void setFromAccountList(List<FromAccountRequest> fromAccountList) {
        this.fromAccountList = fromAccountList;
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

}
