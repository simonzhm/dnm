/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.math.BigDecimal;

/**
 * 金额工具
 * 
 * @author hongmin.zhonghm
 * @version $Id: AmountUtil.java, v 0.1 2014-5-22 下午1:53:13 hongmin.zhonghm Exp $
 */
public class AmountUtil {

    /**
     * 判断金额是否大于0
     * 
     * @param amount
     * @return
     */
    public static boolean isGreaterThanZero(BigDecimal amount) {
        return amount != null && amount.compareTo(new BigDecimal(0)) > 0;
    }

    /**
     * 判断金额是否大于或等于0
     * 
     * @param amount
     * @return
     */
    public static boolean isGreaterOrEqualZero(BigDecimal amount) {
        return amount != null && amount.compareTo(new BigDecimal(0)) >= 0;
    }

    /**
     * 金额加到原来的对象上，并返回新的对象
     * 
     * @param origAmt
     * @param addAmt
     * @return
     */
    public static BigDecimal add(BigDecimal origAmt, BigDecimal addAmt) {
        if (origAmt == null) {
            origAmt = addAmt;
        } else {
            if (addAmt != null) {
                origAmt = origAmt.add(addAmt);
            }
        }

        return origAmt;
    }

    /**
     * 金额从原来的对象上减去，并返回新的对象
     * 
     * @param origAmt
     * @param subAmt
     * @return
     */
    public static BigDecimal substract(BigDecimal origAmt, BigDecimal subAmt) {
        if (origAmt != null && subAmt != null) {
            origAmt = origAmt.subtract(subAmt);
        }

        return origAmt;
    }
}
