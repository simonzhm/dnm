/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTypeEnum.java, v 0.1 2014-5-5 上午11:22:38 hongmin.zhonghm Exp $
 */
public enum AccountTypeEnum {

    /** 银行 */
    BANK("10", "银行"),

    /** 平台 */
    PLATFORM("20", "平台"),

    ;

    /** 枚举编码 */
    private final String                        code;

    /** 描述说明 */
    private final String                        description;

    /** 枚举缓存 */
    private static Map<String, AccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, AccountTypeEnum>();
        AccountTypeEnum[] enums = AccountTypeEnum.values();
        for (AccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private AccountTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
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
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code  简码
     * @return      枚举
     */
    public static AccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
