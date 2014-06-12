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
 * 账户三级类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: ThirdAccountTypeEnum.java.java, v 0.1 2014-5-5 上午11:22:38 hongmin.zhonghm Exp $
 */
public enum ThirdAccountTypeEnum {
    /** 贷记卡 */
    CREDIT_CARD(SecondAccountTypeEnum.CREDIT_CARD.getCode() + "01", "贷记卡",
                AccountDirectionEnum.CREDIT),

    /** 借记卡 */
    DEBIT_CARD(SecondAccountTypeEnum.DEBIT_CARD.getCode() + "01", "借记卡", AccountDirectionEnum.DEBIT),

    /** 可用余额 */
    PLATFORM_BALANCE(SecondAccountTypeEnum.PLATFORM_BALANCE.getCode() + "01", "可用余额",
                     AccountDirectionEnum.DEBIT),

    /** 待收余额 */
    PLATFORM_DUEIN(SecondAccountTypeEnum.PLATFORM_BALANCE.getCode() + "02", "待收余额",
                   AccountDirectionEnum.DEBIT),

    /** 待收利息 */
    PLATFORM_DUEIN_INTEREST(SecondAccountTypeEnum.PLATFORM_DUEIN.getCode() + "01", "待收利息",
                            AccountDirectionEnum.CREDIT),

    /** 待收奖励 */
    PLATFORM_DUEIN_PRICE(SecondAccountTypeEnum.PLATFORM_DUEIN.getCode() + "02", "待收奖励 ",
                         AccountDirectionEnum.CREDIT),

    /** 已收奖励 */
    PLATFORM_PRICE(SecondAccountTypeEnum.PLATFORM_RECEIVED.getCode() + "01", "已收奖励 ",
                   AccountDirectionEnum.CREDIT),

    /** 已收利息 */
    PLATFORM_INTEREST(SecondAccountTypeEnum.PLATFORM_RECEIVED.getCode() + "02", "已收利息",
                      AccountDirectionEnum.CREDIT),

    /** 平台费用 */
    PLATFORM_COST(SecondAccountTypeEnum.PLATFORM_COST.getCode() + "01", "平台费用",
                  AccountDirectionEnum.DEBIT),

    ;

    /** 枚举编码 */
    private final String                             code;

    /** 名称 */
    private final String                             name;

    /** 借贷方向 */
    private final AccountDirectionEnum               direction;

    /** 枚举缓存 */
    private static Map<String, ThirdAccountTypeEnum> enumMap;

    static {
        enumMap = new HashMap<String, ThirdAccountTypeEnum>();
        ThirdAccountTypeEnum[] enums = ThirdAccountTypeEnum.values();
        for (ThirdAccountTypeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * 获取平台相关账户子类型
     * 
     * @return
     */
    public static List<ThirdAccountTypeEnum> getPlatformSubAccountTypes() {
        List<ThirdAccountTypeEnum> types = new ArrayList<ThirdAccountTypeEnum>();
        types.add(ThirdAccountTypeEnum.PLATFORM_BALANCE);
        types.add((ThirdAccountTypeEnum.PLATFORM_DUEIN));
        types.add((ThirdAccountTypeEnum.PLATFORM_DUEIN_INTEREST));
        types.add((ThirdAccountTypeEnum.PLATFORM_INTEREST));
        types.add((ThirdAccountTypeEnum.PLATFORM_DUEIN_PRICE));
        types.add((ThirdAccountTypeEnum.PLATFORM_PRICE));
        types.add((ThirdAccountTypeEnum.PLATFORM_COST));

        return types;
    }

    /**
     * @param code
     * @param name
     */
    private ThirdAccountTypeEnum(String code, String description, AccountDirectionEnum direction) {
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
    public static ThirdAccountTypeEnum getByCode(String code) {
        return enumMap.get(code);
    }

}
