/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 是或否枚举
 * 
 * @author hongmin.zhonghm
 * @version $Id: YesOrNoEnum.java, v 0.1 2014-5-5 下午1:54:09 hongmin.zhonghm Exp $
 */
public enum YesOrNoEnum {
    /** Yes */
    YES("Y", "Yes"),

    /** No */
    NO("N", "No"),

    ;

    /** 货币编码 */
    private final String                    code;

    /** 货币编号 */
    private final String                    value;

    /** 枚举缓存 */
    private static Map<String, YesOrNoEnum> enumMap;

    static {
        enumMap = new HashMap<String, YesOrNoEnum>();
        YesOrNoEnum[] enums = YesOrNoEnum.values();
        for (YesOrNoEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private YesOrNoEnum(String code, String description) {
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
    public static YesOrNoEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
