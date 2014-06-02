/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 数据库主键生成方式
 * 
 * @author hongmin.zhonghm
 * @version $Id: DBKeyUtil.java, v 0.1 2014-4-14 上午10:45:51 hongmin.zhonghm Exp $
 */
public class DBKeyUtil {
    /** 用户分库分表起始位 */
    private static final int USER_DB_KEY_START    = -12;

    /** 用户分库分表结束位 */
    private static final int USER_DB_KEY_END      = -10;

    /** 用户分库分表起始位 */
    private static final int VERSION_DB_KEY_START = 8;

    /** 用户分库分表结束位 */
    private static final int VERSION_DB_KEY_END   = 9;

    /**
     * 普通主键补足,非关键流水ID可使用此生成方法。
     * <p>
     * 格式：8位日期+12位seq
     *
     * @param now  当前时间
     * @param seq  sequence
     * @return     id
     */
    public static String complete(Date now, long seq) {

        String realSeq = StringUtil.alignRight(String.valueOf(seq), 12, '0');
        String today = getPartition(now);
        return today + realSeq;
    }

    /**
     * 生成16位普通主键
     * <p>
     * 格式：8位日期+8位seq
     *
     * @param now  当前时间
     * @param seq  sequence
     * @return     id
     */
    public static String complete16(Date now, long seq) {

        String realSeq = StringUtil.alignRight(String.valueOf(seq), 8, '0');
        String today = getPartition(now);
        return today + realSeq;
    }

    /**
     * 生成20位的账户ID
     * <p>
     * 格式：8位日期+8位seq+版本+币种
     *
     * @param now  当前时间
     * @param seq  sequence
     * @return     id
     */
    public static String completeAccountId(Date now, long seq, String currency) {

        String realSeq = StringUtil.alignRight(String.valueOf(seq), 8, '0');
        String today = getPartition(now);
        return today + realSeq + "0" + currency;
    }

    /**
     * 主键补足，符合支付宝三代架构中有关流水ID的数据架构规范标准。
     * <p>
     * 基本格式：日期(8)+数据版本(1)+系统版本(1)+系统标识码(3)+业务标识码(3)+业务扩展位(可选)+用户分表位(2)+随机用户分表位(2)+seq(8)
     * <br>
     * 定制格式：日期(8)+数据版本(1)+系统版本(1)+系统标识码(3)+业务标识码(3)+业务扩展位(3)+ 用户分表位(2)+随机用户分表位(2)+seq(8)
     * @param now           当前时间
     * @param dataVersion   数据版本
     * @param systemVersion 系统版本
     * @param systemCode    系统标志码
     * @param bizCode       业务标志码
     * @param accountNo     账号或用户卡号
     * @param seq           序列号
     * @return              id
     */
    public static String complete(Date now, String dataVersion, String systemVersion,
                                  String systemCode, String bizCode, String accountNo, long seq) {

        //入参检查
        if (StringUtil.isBlank(systemCode) || seq <= 0 || seq > 99999999) {
            throw new RuntimeException("参数不合法");
        }

        //日期位
        String today = getPartition(now);

        //8位长seq
        String realSeq = StringUtil.alignRight(String.valueOf(seq), 8, '0');

        //数据版本
        if (StringUtil.isBlank(dataVersion)) {
            dataVersion = "1";
        }

        //系统版本
        if (StringUtil.isBlank(systemVersion)) {
            systemVersion = "1";
        }

        //业务标识码
        //默认加入用户扩展位
        if (StringUtil.isBlank(bizCode)) {
            bizCode = "000000";
        }

        //用户分表位
        String userPartition = "00";
        if (!StringUtil.isBlank(accountNo)) {
            userPartition = StringUtil.substring(accountNo, 13, 15);
        }

        //用户随机分表位
        Random random = new Random();
        String userRadomPartition = StringUtil.alignRight(String.valueOf(random.nextInt(99)), 2,
            '0');

        return today + dataVersion + systemVersion + systemCode + bizCode + userPartition
               + userRadomPartition + realSeq;
    }

    /**
     * 根据其他主键单号生成新主键单号，确保相同的分库分表位。符合支付宝三代架构中有关流水ID的数据架构规范标准。
     * <p>
     * 基本格式：日期(8)+数据版本(1)+系统版本(1)+系统标识码(3)+业务标识码(3)+业务扩展位(可选)+用户分表位(2)+随机用户分表位(2)+seq(8)
     * <br>
     * 定制格式：日期(8)+数据版本(1)+系统版本(1)+系统标识码(3)+业务标识码(3)+业务扩展位(3)+ 用户分表位(2)+随机用户分表位(2)+seq(8)
     * @param now           当前时间
     * @param dataVersion   数据版本
     * @param systemVersion 系统版本
     * @param systemCode    系统标志码
     * @param bizCode       业务标志码
     * @param relatedKey    关联单号
     * @param seq           序列号
     * @return              id
     */
    public static String completeByRelatedKey(Date now, String dataVersion, String systemVersion,
                                              String systemCode, String bizCode, String relatedKey,
                                              long seq) {

        String dbKey = complete(now, dataVersion, systemVersion, systemCode, bizCode, null, seq);

        String userDBKey = StringUtil.substring(relatedKey, USER_DB_KEY_START, USER_DB_KEY_END);

        if (StringUtil.isBlank(userDBKey) || userDBKey.length() != 2) {

            throw new RuntimeException("relatedKey is invalid");
        }

        return StringUtil.substring(dbKey, 0, USER_DB_KEY_START) + userDBKey
               + StringUtil.substring(dbKey, USER_DB_KEY_END);
    }

    /**
     * 获取主键单号中的版本位。
     * 
     * @param key   主键单号
     * @return      单号版本位
     */
    public static String getDataVersion(String key) {

        if (StringUtil.isBlank(key)) {

            return null;
        }

        String dataVersion = StringUtil.substring(key, VERSION_DB_KEY_START, VERSION_DB_KEY_END);

        return dataVersion;
    }

    /**
     * 日期转换。
     *
     * @param date   时间
     * @return       日期
     */
    public static String getPartition(Date date) {

        //前8位yyyyMMdd格式
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String partitionKey = dateFormat.format(date);
        return partitionKey;
    }
}
