/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.request;

import com.dnm.facade.anotation.RequestFieldCheck;

/**
 * 投标奖励费用请求单据 
 * @see BaseRequestOrder
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestPriceCostRequest.java, v 0.1 2014-4-7 下午5:14:33 hongmin.zhonghm Exp $
 */
public final class InvestPriceCostRequest extends BaseRequestOrder {

    /** serialVersionUID */
    private static final long serialVersionUID = -2673449503705890251L;

    /** 类型 SubTransCodeEnum*/
    @RequestFieldCheck(notEmpty = true)
    private String            type;

    /** 原始计算金额 */
    @RequestFieldCheck(notEmpty = true)
    private String            origAmt;

    /** 比例 */
    @RequestFieldCheck(notEmpty = true)
    private String            rate;

    /** 实际计算结果金额 */
    @RequestFieldCheck(notEmpty = true)
    private String            actualAmt;

    /**
     * Getter method for property <tt>type</tt>.
     * 
     * @return property value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     * 
     * @param type value to be assigned to property type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter method for property <tt>origAmt</tt>.
     * 
     * @return property value of origAmt
     */
    public String getOrigAmt() {
        return origAmt;
    }

    /**
     * Setter method for property <tt>origAmt</tt>.
     * 
     * @param origAmt value to be assigned to property origAmt
     */
    public void setOrigAmt(String origAmt) {
        this.origAmt = origAmt;
    }

    /**
     * Getter method for property <tt>rate</tt>.
     * 
     * @return property value of rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * Setter method for property <tt>rate</tt>.
     * 
     * @param rate value to be assigned to property rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Getter method for property <tt>actualAmt</tt>.
     * 
     * @return property value of actualAmt
     */
    public String getActualAmt() {
        return actualAmt;
    }

    /**
     * Setter method for property <tt>actualAmt</tt>.
     * 
     * @param actualAmt value to be assigned to property actualAmt
     */
    public void setActualAmt(String actualAmt) {
        this.actualAmt = actualAmt;
    }

}
