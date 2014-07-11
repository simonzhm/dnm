/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.enums;

/**
 * 访问器枚举
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccessorEnum.java, v 0.1 2014-4-13 上午12:58:49 hongmin.zhonghm Exp $
 */
public enum AccessorEnum {

    /** 用户信息访问器 */
    USER("USER", "用户信息访问器"),

    /**账户访问器 */
    ACCOUNT("ACCOUNT", "账户访问器"),

    /**账户访问器(ACCOUNT_TRANS_LOG_MODEL) */
    ACCOUNT_FOR_TRANS_LOG("ACCOUNT_FOR_TRANS_LOG", "账户访问器(ACCOUNT_TRANS_LOG_MODEL)"),

    /**银行访问器 */
    BANK("BANK", "银行访问器"),

    /**平台访问器 */
    PLATFORM("PLATFORM", "平台访问器"),

    /**平台用户访问器 */
    PLATFORM_USER("PLATFORM_USER", "平台用户访问器"),

    /**平台用户账户映射访问器 */
    PLATFORM_USER_ACCOUNT("PLATFORM_USER_ACCOUNT", "平台用户账户映射访问器"),
    
    /**投标访问器 */
    INVEST_RCD("INVEST_RCD", "投标访问器"),
    
    /**投标明细访问器 */
    INVEST_DUEIN_RCD("INVEST_DUEIN_RCD", "投标明细访问器"),
    
    /**投标来源账户访问器 */
    INVEST_FROM_ACCOUNT("INVEST_FROM_ACCOUNT", "投标来源账户访问器"),
    
    /**投标奖励费用访问器 */
    INVEST_PRICE_COST("INVEST_PRICE_COST", "投标奖励费用访问器"),

    /**账户交易日志访问器 */
    ACCOUNT_TRANS_LOG("ACCOUNT_TRANS_LOG", "账户交易日志访问器"),

    /**账户日志访问器 */
    ACCOUNT_LOG("ACCOUNT_LOG", "账户日志访问器"),

    ;

    /** 简码 */
    private final String code;

    /** 描述 */
    private final String description;

    /**
     * 私有构造方法
     * 
     * @param code          简码
     * @param description   描述
     */
    private AccessorEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the description.
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
    public static AccessorEnum getByCode(String code) {
        for (AccessorEnum accessor : values()) {
            if (accessor.getCode().equals(code)) {
                return accessor;
            }
        }
        return null;
    }
}
