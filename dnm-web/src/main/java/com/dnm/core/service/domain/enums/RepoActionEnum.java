/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.enums;

/**
 * 仓储操作类型枚举
 * 
 * @author hongmin.zhonghm
 * @version $Id: RepoActionEnum.java, v 0.1 2014-4-13 上午12:59:50 hongmin.zhonghm Exp $
 */
public enum RepoActionEnum {
    /** 插入操作 */
    STORE("store", "持久化操作"),

    /** 更新操作 */
    RESTORE("restore", "更新操作"),

    /** 删除操作 */
    DEPRECATE("deprecate", "删除操作"),

    /** 激活操作 */
    ACTIVE("active", "激活操作"),

    /** 加载操作 */
    LOAD("load", "加载操作"),

    /** 加载操作，特指非主键加载 */
    RELOAD("reload", "非主键加载操作"), ;

    /** 操作代码 */
    private final String code;

    /** 描述 */
    private final String desc;

    /**
     * 构造方法
     * @param code 操作代码
     * @param desc 描述
     */
    private RepoActionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     * @param code 操作代码
     * @return 操作操作类型
     */
    public static RepoActionEnum getByCode(String code) {
        for (RepoActionEnum operateEnum : values()) {
            if (operateEnum.getCode().equals(code)) {
                return operateEnum;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>payToolCode</tt>.
     *
     * @return property value of payToolCode
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }
}
