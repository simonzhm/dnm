/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户子交易码
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubAccountTransCodeEnum.java, v 0.1 2014-5-13 下午2:07:55 hongmin.zhonghm Exp $
 */
public enum SubAccountTransCodeEnum {

    /** 待收利息*/
    DUEIN_INTEREST(AccountTransCodeEnum.DUEIN.getCode() + "0001", "待收利息"),

    /** 待收续奖 */
    DUEIN_REINVEST_PRICE(AccountTransCodeEnum.DUEIN.getCode() + "0002", "待收续奖"),

    /** 普通投标 */
    NORMAL_INVEST(AccountTransCodeEnum.INVEST.getCode() + "0001", "普通投标"),

    /** 本金回款 */
    PRINCIPAL_RECEIVE(AccountTransCodeEnum.RECEIVE.getCode() + "0001", "本金回款"),

    /** 利息回款 */
    INTEREST_RECEIVE(AccountTransCodeEnum.RECEIVE.getCode() + "0002", "利息回款"),

    /** 续奖回款 */
    REINVEST_PRICE_RECEIVE(AccountTransCodeEnum.RECEIVE.getCode() + "0003", "续奖回款"),

    /** 利息费用 */
    INTEREST_FEE(AccountTransCodeEnum.COST.getCode() + "0001", "利息费用"),

    /** 会员费用 */
    VIP_FEE(AccountTransCodeEnum.COST.getCode() + "0002", "会员费用"),

    /** 充值费用 */
    DEPOSIT_FEE(AccountTransCodeEnum.COST.getCode() + "0003", "充值费用"),

    /** 线下充值奖励实时发放 */
    OFFLINE_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0001", "线下充值奖（实时）"),

    /** 投奖实时发放 */
    INVEST_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0002", "投标奖（实时）"),

    /** 利息发放  */
    INTEREST(AccountTransCodeEnum.INCOME.getCode() + "0003", "利息"),

    /** 罚息实时发放  */
    OVERDUE_INTEREST_IMED(AccountTransCodeEnum.INCOME.getCode() + "0004", "罚息（实时）"),

    /** 续奖发放 */
    RE_INVEST_PRICE(AccountTransCodeEnum.INCOME.getCode() + "0005", "续投奖"),

    /** 活动奖实时发放 */
    PROMOTION_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0006", "活动奖（实时）"),
    
    /** 续奖实时发放 */
    RE_INVEST_PRICE_IMED(AccountTransCodeEnum.INCOME.getCode() + "0007", "续投奖（实时）"),

    /** 线上借记卡充值 */
    ONLINE_DEBIT_DEPOSIT(AccountTransCodeEnum.DEPOSIT.getCode() + "0001", "线上借记卡充值"),

    /** 线上信用卡充值 */
    ONLINE_CREDIT_DEPOSIT(AccountTransCodeEnum.DEPOSIT.getCode() + "0002", "线上信用卡充值"),

    /** 线下借记卡充值 */
    OFFLINE_DEPOSIT(AccountTransCodeEnum.DEPOSIT.getCode() + "0003", "线下借记卡充值"),

    /** 提现 */
    WITHDRAW(AccountTransCodeEnum.WITHDRAW.getCode() + "0001", "提现"),

    ;

    /** 枚举编码 */
    private final String                                code;

    /** 描述说明 */
    private final String                                description;

    /** 枚举缓存 */
    private static Map<String, SubAccountTransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SubAccountTransCodeEnum>();
        SubAccountTransCodeEnum[] enums = SubAccountTransCodeEnum.values();
        for (SubAccountTransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private SubAccountTransCodeEnum(String code, String description) {
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
    public static SubAccountTransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
