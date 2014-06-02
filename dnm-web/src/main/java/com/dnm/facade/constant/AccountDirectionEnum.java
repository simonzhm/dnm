/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户借贷方向
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDirectionEnum.java, v 0.1 2014-5-5 下午3:43:55 hongmin.zhonghm Exp $
 */
public enum AccountDirectionEnum {

    /** 借 */
    DEBIT("D", "DEBIT"),

    /** 贷 */
    CREDIT("C", "CREDIT"),

    ;

    /** 货币编码 */
    private final String                             code;

    /** 货币编号 */
    private final String                             value;

    /** 枚举缓存 */
    private static Map<String, AccountDirectionEnum> enumMap;

    static {
        enumMap = new HashMap<String, AccountDirectionEnum>();
        AccountDirectionEnum[] enums = AccountDirectionEnum.values();
        for (AccountDirectionEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param value
     */
    private AccountDirectionEnum(String code, String description) {
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
    public static AccountDirectionEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
