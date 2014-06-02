/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 主交易类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: TransCodeEnum.java, v 0.1 2014-5-13 下午2:08:16 hongmin.zhonghm Exp $
 */
public enum TransCodeEnum {

    /** 投标 */
    INVEST("31", "投标"),

    /** 回款 */
    CASHBACK("32", "回款"),

    /** 充值 */
    DEPOSIT("41", "充值"),

    /** 提现 */
    WITHDRAW("51", "提现"),

    ;

    /** 枚举编码 */
    private final String                      code;

    /** 描述说明 */
    private final String                      description;

    /** 枚举缓存 */
    private static Map<String, TransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, TransCodeEnum>();
        TransCodeEnum[] enums = TransCodeEnum.values();
        for (TransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private TransCodeEnum(String code, String description) {
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
    public static TransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
