/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.facade.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务层子交易类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: SubTransCodeEnum.java, v 0.1 2014-5-13 下午2:07:55 hongmin.zhonghm Exp $
 */
public enum SubTransCodeEnum {

    /** 普通投标 */
    NORMAL_INVEST(TransCodeEnum.INVEST.getCode() + "0001", "普通投标"),

    /** 普通回款 */
    NORMAL_CASHBACK(TransCodeEnum.CASHBACK.getCode() + "0001", "普通回款"),

    /** 投标奖(实时) */
    INVEST_PRICE_IMED(TransCodeEnum.PRICE.getCode() + "0001", "投标奖(实时)"),

    /** 续投奖 */
    RE_INVEST_PRICE(TransCodeEnum.PRICE.getCode() + "0002", "续投奖"),
    
    /** 续投奖(实时) */
    RE_INVEST_PRICE_IMED(TransCodeEnum.PRICE.getCode() + "0003", "续投奖(实时)"),

    /** 充值费用 */
    DEPOSIT_FEE(TransCodeEnum.COST.getCode() + "0001", "充值费用"),

    /** 线上充值 */
    ONLINE_DEPOSIT(TransCodeEnum.DEPOSIT.getCode() + "0001", "线上充值"),

    /** 线下充值 */
    OFFLINE_DEPOSIT(TransCodeEnum.DEPOSIT.getCode() + "0002", "线下充值"),

    /** 提现 */
    WITHDRAW(TransCodeEnum.WITHDRAW.getCode() + "0001", "提现"),

    ;

    /** 枚举编码 */
    private final String                         code;

    /** 描述说明 */
    private final String                         description;

    /** 枚举缓存 */
    private static Map<String, SubTransCodeEnum> enumMap;

    static {
        enumMap = new HashMap<String, SubTransCodeEnum>();
        SubTransCodeEnum[] enums = SubTransCodeEnum.values();
        for (SubTransCodeEnum item : enums) {
            enumMap.put(item.code, item);
        }
    }

    /**
     * @param code
     * @param description
     */
    private SubTransCodeEnum(String code, String description) {
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
    public static SubTransCodeEnum getByCode(String code) {
        return enumMap.get(code);
    }
}
