/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.math.BigDecimal;

/**
 * 计算工具
 * 
 * @author hongmin.zhonghm
 * @version $Id: CalculateUtil.java, v 0.1 2014-5-15 下午11:23:51 hongmin.zhonghm Exp $
 */
public class CalculateUtil {

    /**
     * 计算金额，默认保留两位小数，四舍五入
     * 
     * @param origAmt 计算金额 (10000.00)
     * @param rate 比例 (21.06%)，传入时没有%，所以计算结果需要除以100
     * @return
     */
    public static BigDecimal calcAmt(String origAmt, String rate, String actualAmt) {
        return calcAmt(getBigDecimal(origAmt), getRateNonPercent(rate), getBigDecimal(actualAmt));
    }

    /**
     * 计算金额，默认保留两位小数，四舍五入
     * 
     * @param origAmt 计算金额 (10000.00)
     * @param rate 比例 (21.06%)，传入时则为0.2106
     * @param actualAmt 实际金额，当该金额不为空时，以该金额为准
     * @return
     */
    public static BigDecimal calcAmt(BigDecimal origAmt, BigDecimal rate, BigDecimal actualAmt) {
        if (actualAmt == null) {
            actualAmt = origAmt;
            actualAmt = actualAmt.multiply(rate);
            actualAmt = actualAmt.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return actualAmt;
    }

    /**
     * 根据年利率计算月利率，保留小数点后4位
     * 
     * @param yearRate
     * @return
     */
    public static BigDecimal calcMonthRate(String yearRate) {
        BigDecimal yr = getRateNonPercent(yearRate);
        return calcMonthRate(yr);
    }

    /**
     * 根据年利率计算月利率，保留小数点后4位
     * 
     * @param yearRate
     * @return
     */
    public static BigDecimal calcMonthRate(BigDecimal yearRate) {
        BigDecimal monthRate = yearRate.divide(new BigDecimal("12"));
        monthRate = monthRate.setScale(4, BigDecimal.ROUND_HALF_UP);
        return monthRate;
    }

    /**
     * 获取没有百分号（%）的利率，保留小数点后4位
     * 
     * @param origRate  22%则输入22
     * @return 不融百分号（%）的利率 0.22
     */
    public static BigDecimal getRateNonPercent(String origRate) {
        return new BigDecimal(origRate).divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 将字符串转换为BigDecimal
     * 
     * @param number
     * @return
     */
    public static BigDecimal getBigDecimal(String number) {
        if (StringUtil.isBlank(number)) {
            return null;
        } else {
            return new BigDecimal(number);
        }
    }

    public static void main(String[] args) {
        System.out.println(CalculateUtil.calcAmt("1000.34", "21.06", null));
    }

}
