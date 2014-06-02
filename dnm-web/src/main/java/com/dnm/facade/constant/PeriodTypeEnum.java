/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 期限定义
 * 期限类型（年Y，月M，天D，秒S）
 * 
 * @author hongmin.zhonghm
 * @version $Id: PeriodTypeEnum.java, v 0.1 2014-5-26 上午12:13:34 hongmin.zhonghm Exp $
 */
public enum PeriodTypeEnum {

    /** 等额本息 */
    YEAR("Y", "年"),

    /** 等额本息 */
    MONTH("M", "月"),

    /** 等额本金 */
    DAY("D", "天"),

    /** 按月付息到期还本 */
    SECOND("S", "秒"),

    ;

    /** 编码 */
    private final String                       code;

    /** 描述 */
    private final String                       value;

    /** 枚举缓存 */
    private static Map<String, PeriodTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, PeriodTypeEnum>();
        PeriodTypeEnum[] enums = PeriodTypeEnum.values();
        for (PeriodTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private PeriodTypeEnum(String code, String description) {
        this.code = code;
        this.value = description;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>value</tt>.
     * 
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code  简码
     * @return      枚举
     */
    public static PeriodTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
