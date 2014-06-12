/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.resultcode;

import com.dnm.core.common.util.StringUtil;

/**
 * <p>拒付结果码枚举。
 * <ul>遵循国际支付标准结果码格式。
 * <li> <code>DNM_RS_</code> [固定前缀]
 * <li> <code>1:INFO; 3:WARN; 5:ERROR; 7:FATAL</code> [返回码级别]
 * <li> <code>0:成功; 1:业务错误; 2:系统错误; 3:第三方错误</code> [返回码类型]
 * <li> <code>001:dnm; 002:xxx ;003:xxx</code> [模块]
 * <li> <code>0XXX:通用错误码; 1XXX~9XXX:业务错误码</code> [错误明细编码]
 * </ul>
 * <ul>业务错误码首位定义（后3位错误码不限制，从000开始）
 * <li> <code>1：用户业务类</code>
 * <li> <code>9：通用业务类</code>
 * </ul>
 * <ul>其中通用错误码包含：
 * <li>成功:IPAY_RS_100000200
 * <li>未知异常:IPAY_RS_520000500
 * <li>参数错误:IPAY_RS_510000400
 * <li>重复提交:IPAY_RS_510000401
 * </ul>
 * </p>
 * 
 * @author hongmin.zhonghm
 * @version $Id: ResultCodeEnum.java, v 0.1 2014-4-7 下午8:24:51 hongmin.zhonghm Exp $
 */
public enum ResultCodeEnum {
    //========================================================================//
    //                            公共结果码                                                                                   //
    //========================================================================//

    /** 处理成功 */
    SUCCESS("DNM_RS_100000200", "success"),

    /** 系统异常 */
    SYSTEM_ERROR("DNM_RS_520000500", "system error"),

    /** 参数不合法 */
    PARAM_ILLEGAL("DNM_RS_510000400", "request param illegal"),

    /** 重复请求 */
    REPEAT_REQUEST("DNM_RS_510000401", "repeat request"),

    //========================================================================//
    //                            通用结果码                                                                                           //
    //========================================================================//
    /** 模型数据完整性校验失败 */
    MODEL_INTEGRITY_CHECK_FAIL("DNM_RS_510019000", "model integrity check fail"),

    /** 业务数据不完整 */
    BIZ_PARAM_ILLEGAL("DNM_RS_510019001", "biz data not integrity"),

    /** 唯一性约束 */
    DUPLICATE_KEY("DNM_RS_510019002", "duplicate key"),

    /** 数据库更新条数异常 */
    DB_UPDATE_COUNT_ERROR("DNM_RS_510019003", "db update count error"),

    //========================================================================//
    //                            业务结果码                                                                                           //
    //========================================================================//
    /**================== 用户业务处理错误  1xxx ====================*/
    /** 用户业务处理错误 */
    USER_BIZ_ERROR("DNM_RS_510011000", "user biz process error"),

    /**================== 账户业务处理错误  2xxx ====================*/
    /** 账号不存在 */
    ACCOUNT_NOT_EXISTS("DNM_RS_510012000", "account not exists"),
    /** 账户不合法 */
    ACCOUNT_ILLEGAL("DNM_RS_510012001", "account illegal"),
    /** 账户查询失败 */
    ACCOUNT_QUERY_FAIL("DNM_RS_510012002", "account query fail"),

    /**================== 投标业务处理错误  3xxx ====================*/
    /** 用户业务处理错误 */
    INVEST_BIZ_ERROR("DNM_RS_510011000", "user biz process error"),

    /**================== 账务处理错误  4xxx ====================*/
    /** 记账失败 */
    ACCOUNT_TRANS_FAIL("DNM_RS_510014000", "account transfer fail"),

    ;

    /** 结果码编号 */
    private String code;

    /** 详情 */
    private String description;

    /**
     * 私有构造方法
     * 
     * @param code 结果码
     * @param desc 结果码对应的详情
     */
    private ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.description = desc;
    }

    /**
     * 获取字符串格式的结果代码
     * 
     * @return 结果代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取结果码对应的详情
     * 
     * @return 结果码详情
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code 字符串结果码
     * @return 枚举结果码，如果没有则返回null
     */
    public static ResultCodeEnum getByCode(String code) {
        for (ResultCodeEnum icbResultCode : values()) {
            if (StringUtil.equals(icbResultCode.getCode(), code)) {
                return icbResultCode;
            }
        }
        return null;
    }

    /**
     * 通过枚举<code>name</code>获得枚举。
     *
     *
     * @param name 枚举名
     * @return 名字对应的枚举，如果没有返回null
     */
    public static ResultCodeEnum getByName(String name) {

        for (ResultCodeEnum icbResultCode : values()) {
            if (StringUtil.equals(icbResultCode.name(), name)) {
                return icbResultCode;
            }
        }
        return null;
    }
}
