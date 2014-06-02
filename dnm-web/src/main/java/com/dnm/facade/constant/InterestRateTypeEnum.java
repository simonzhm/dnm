/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 利息类型（年，天）
 * 
 * @author hongmin.zhonghm
 * @version $Id: FeeRateTypeEnum.java, v 0.1 2014-5-5 下午3:43:55 hongmin.zhonghm Exp $
 */
public enum InterestRateTypeEnum {

    /** 年 */
    YEAR("Y", "YEAR"),

    /** 天 */
    DATE("D", "DATE"),

    ;

    /** 编码 */
    private final String                        code;

    /** 值 */
    private final String                        value;

    /** 枚举缓存 */
    private static Map<String, InterestRateTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, InterestRateTypeEnum>();
        InterestRateTypeEnum[] enums = InterestRateTypeEnum.values();
        for (InterestRateTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private InterestRateTypeEnum(String code, String description) {
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
    public static InterestRateTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
