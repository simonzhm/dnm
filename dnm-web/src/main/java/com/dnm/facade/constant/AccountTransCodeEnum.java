/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 账务主交易码
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransCodeEnum.java, v 0.1 2014-5-13 下午2:08:16 hongmin.zhonghm Exp $
 */
public enum AccountTransCodeEnum {

    /** 待收 */
    DUEIN("21", "待收"),

    /** 投标 */
    INVEST("31", "投标"),

    /** 回款 */
    RECEIVE("32", "回款"),

    /** 费用 */
    COST("41", "费用"),

    /** 收入 */
    INCOME("42", "收入"),

    /** 充值 */
    DEPOSIT("51", "充值"),

    /** 提现 */
    WITHDRAW("52", "提现"),

    ;

    /** 枚举编码 */
    private final String                             code;

    /** 描述说明 */
    private final String                             description;

    /** 枚举缓存 */
    private static Map<String, AccountTransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, AccountTransCodeEnum>();
        AccountTransCodeEnum[] enums = AccountTransCodeEnum.values();
        for (AccountTransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private AccountTransCodeEnum(String code, String description) {
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
    public static AccountTransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
