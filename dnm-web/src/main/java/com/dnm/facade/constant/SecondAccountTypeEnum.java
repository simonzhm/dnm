/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户二级类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: SecondAccountTypeEnum.java.java, v 0.1 2014-5-5 上午11:22:38 hongmin.zhonghm Exp $
 */
public enum SecondAccountTypeEnum {

    /** 贷记卡 */
    CREDIT_CARD(AccountTypeEnum.BANK.getCode() + "01", "贷记卡", AccountDirectionEnum.CREDIT),

    /** 借记卡 */
    DEBIT_CARD(AccountTypeEnum.BANK.getCode() + "02", "借记卡", AccountDirectionEnum.DEBIT),

    /** 余额 */
    PLATFORM_BALANCE(AccountTypeEnum.PLATFORM.getCode() + "01", "余额", AccountDirectionEnum.DEBIT),

    /** 待收 */
    PLATFORM_DUEIN(AccountTypeEnum.PLATFORM.getCode() + "02", "待收", AccountDirectionEnum.CREDIT),

    /** 已收 */
    PLATFORM_RECEIVED(AccountTypeEnum.PLATFORM.getCode() + "03", "已收", AccountDirectionEnum.CREDIT),

    /** 费用 */
    PLATFORM_COST(AccountTypeEnum.PLATFORM.getCode() + "04", "费用", AccountDirectionEnum.DEBIT),

    ;

    /** 枚举编码 */
    private final String                              code;

    /** 名称 */
    private final String                              name;

    /** 借贷方向 */
    private final AccountDirectionEnum                direction;

    /** 枚举缓存 */
    private static Map<String, SecondAccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SecondAccountTypeEnum>();
        SecondAccountTypeEnum[] enums = SecondAccountTypeEnum.values();
        for (SecondAccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param name
     */
    private SecondAccountTypeEnum(String code, String description, AccountDirectionEnum direction) {
        this.code = code;
        this.name = description;
        this.direction = direction;
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
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>direction</tt>.
     * 
     * @return property value of direction
     */
    public AccountDirectionEnum getDirection() {
        return direction;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code  简码
     * @return      枚举
     */
    public static SecondAccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
