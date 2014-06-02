/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 还款方式定义
 * A:一次性还款，B:等额本息，C:等额本金，D:按月付息到期还本
 * 
 * @author hongmin.zhonghm
 * @version $Id: RepayMethodEnum.java, v 0.1 2014-5-25 下午10:58:00 hongmin.zhonghm Exp $
 */
public enum RepayMethodEnum {

    /** 等额本息 */
    ALL("A", "一次性还款"),

    /** 等额本息 */
    EQUALS_PRINCIPAL_INTEREST("B", "等额本息"),

    /** 等额本金 */
    EQUALS_PRINCIPAL("C", "等额本金"),

    /** 按月付息到期还本 */
    MONTH_INTEREST("D", "按月付息到期还本"),

    ;

    /** 编码 */
    private final String                        code;

    /** 描述 */
    private final String                        value;

    /** 枚举缓存 */
    private static Map<String, RepayMethodEnum> enumMap;

    static {
        enumMap = new HashMap<String, RepayMethodEnum>();
        RepayMethodEnum[] enums = RepayMethodEnum.values();
        for (RepayMethodEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private RepayMethodEnum(String code, String description) {
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
    public static RepayMethodEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
