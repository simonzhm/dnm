/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账户子类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTypeEnum.java.java, v 0.1 2014-5-5 上午11:22:38 hongmin.zhonghm Exp $
 */
public enum SubAccountTypeEnum {

    /** 贷记卡 */
    CREDIT_CARD(AccountTypeEnum.BANK.getCode() + "01", "贷记卡", AccountDirectionEnum.CREDIT),

    /** 借记卡 */
    DEBIT_CARD(AccountTypeEnum.BANK.getCode() + "02", "借记卡", AccountDirectionEnum.DEBIT),

    /** 可用余额 */
    PLATFORM_BALANCE(AccountTypeEnum.PLATFORM.getCode() + "01", "可用余额", AccountDirectionEnum.DEBIT),

    /** 待收余额 */
    PLATFORM_DUEIN(AccountTypeEnum.PLATFORM.getCode() + "02", "待收余额", AccountDirectionEnum.DEBIT),

    /** 待收利息 */
    PLATFORM_DUEIN_INTEREST(AccountTypeEnum.PLATFORM.getCode() + "03", "待收利息",
                            AccountDirectionEnum.CREDIT),

    /** 已收利息 */
    PLATFORM_INTEREST(AccountTypeEnum.PLATFORM.getCode() + "04", "已收利息",
                      AccountDirectionEnum.CREDIT),

    /** 待收奖励 */
    PLATFORM_DUEIN_PRICE(AccountTypeEnum.PLATFORM.getCode() + "05", "待收奖励 ",
                         AccountDirectionEnum.CREDIT),

    /** 已收奖励 */
    PLATFORM_PRICE(AccountTypeEnum.PLATFORM.getCode() + "06", "已收奖励 ", AccountDirectionEnum.CREDIT),

    /** 平台费用 */
    PLATFORM_COST(AccountTypeEnum.PLATFORM.getCode() + "07", "平台费用", AccountDirectionEnum.DEBIT),

    ;

    /** 枚举编码 */
    private final String                           code;

    /** 名称 */
    private final String                           name;

    /** 借贷方向 */
    private final AccountDirectionEnum             direction;

    /** 枚举缓存 */
    private static Map<String, SubAccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SubAccountTypeEnum>();
        SubAccountTypeEnum[] enums = SubAccountTypeEnum.values();
        for (SubAccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * 获取平台相当账户子类型
     * 
     * @return
     */
    public static List<SubAccountTypeEnum> getPlatformSubAccountTypes() {
        List<SubAccountTypeEnum> types = new ArrayList<SubAccountTypeEnum>();
        types.add(SubAccountTypeEnum.PLATFORM_BALANCE);
        types.add((SubAccountTypeEnum.PLATFORM_DUEIN));
        types.add((SubAccountTypeEnum.PLATFORM_DUEIN_INTEREST));
        types.add((SubAccountTypeEnum.PLATFORM_INTEREST));
        types.add((SubAccountTypeEnum.PLATFORM_DUEIN_PRICE));
        types.add((SubAccountTypeEnum.PLATFORM_PRICE));
        types.add((SubAccountTypeEnum.PLATFORM_COST));

        return types;
    }

    /**
     * @param code
     * @param name
     */
    private SubAccountTypeEnum(String code, String description, AccountDirectionEnum direction) {
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
    public static SubAccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
