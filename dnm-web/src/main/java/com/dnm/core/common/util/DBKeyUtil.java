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
 * ���ݿ��������ɷ�ʽ
 * 
 * @author hongmin.zhonghm
 * @version $Id: DBKeyUtil.java, v 0.1 2014-4-14 ����10:45:51 hongmin.zhonghm Exp $
 */
public class DBKeyUtil {
    /** �û��ֿ�ֱ���ʼλ */
    private static final int USER_DB_KEY_START    = -12;

    /** �û��ֿ�ֱ����λ */
    private static final int USER_DB_KEY_END      = -10;

    /** �û��ֿ�ֱ���ʼλ */
    private static final int VERSION_DB_KEY_START = 8;

    /** �û��ֿ�ֱ����λ */
    private static final int VERSION_DB_KEY_END   = 9;

    /**
     * ��ͨ��������,�ǹؼ���ˮID��ʹ�ô����ɷ�����
     * <p>
     * ��ʽ��8λ����+12λseq
     *
     * @param now  ��ǰʱ��
     * @param seq  sequence
     * @return     id
     */
    public static String complete(Date now, long seq) {

        String realSeq = StringUtil.alignRight(String.valueOf(seq), 12, '0');
        String today = getPartition(now);
        return today + realSeq;
    }

    /**
     * ����16λ��ͨ����
     * <p>
     * ��ʽ��8λ����+8λseq
     *
     * @param now  ��ǰʱ��
     * @param seq  sequence
     * @return     id
     */
    public static String complete16(Date now, long seq) {

        String realSeq = StringUtil.alignRight(String.valueOf(seq), 8, '0');
        String today = getPartition(now);
        return today + realSeq;
    }

    /**
     * ����20λ���˻�ID
     * <p>
     * ��ʽ��8λ����+8λseq+�汾+����
     *
     * @param now  ��ǰʱ��
     * @param seq  sequence
     * @return     id
     */
    public static String completeAccountId(Date now, long seq, String currency) {

        String realSeq = StringUtil.alignRight(String.valueOf(seq), 8, '0');
        String today = getPartition(now);
        return today + realSeq + "0" + currency;
    }

    /**
     * �������㣬����֧���������ܹ����й���ˮID�����ݼܹ��淶��׼��
     * <p>
     * ������ʽ������(8)+���ݰ汾(1)+ϵͳ�汾(1)+ϵͳ��ʶ��(3)+ҵ���ʶ��(3)+ҵ����չλ(��ѡ)+�û��ֱ�λ(2)+����û��ֱ�λ(2)+seq(8)
     * <br>
     * ���Ƹ�ʽ������(8)+���ݰ汾(1)+ϵͳ�汾(1)+ϵͳ��ʶ��(3)+ҵ���ʶ��(3)+ҵ����չλ(3)+ �û��ֱ�λ(2)+����û��ֱ�λ(2)+seq(8)
     * @param now           ��ǰʱ��
     * @param dataVersion   ���ݰ汾
     * @param systemVersion ϵͳ�汾
     * @param systemCode    ϵͳ��־��
     * @param bizCode       ҵ���־��
     * @param accountNo     �˺Ż��û�����
     * @param seq           ���к�
     * @return              id
     */
    public static String complete(Date now, String dataVersion, String systemVersion,
                                  String systemCode, String bizCode, String accountNo, long seq) {

        //��μ��
        if (StringUtil.isBlank(systemCode) || seq <= 0 || seq > 99999999) {
            throw new RuntimeException("�������Ϸ�");
        }

        //����λ
        String today = getPartition(now);

        //8λ��seq
        String realSeq = StringUtil.alignRight(String.valueOf(seq), 8, '0');

        //���ݰ汾
        if (StringUtil.isBlank(dataVersion)) {
            dataVersion = "1";
        }

        //ϵͳ�汾
        if (StringUtil.isBlank(systemVersion)) {
            systemVersion = "1";
        }

        //ҵ���ʶ��
        //Ĭ�ϼ����û���չλ
        if (StringUtil.isBlank(bizCode)) {
            bizCode = "000000";
        }

        //�û��ֱ�λ
        String userPartition = "00";
        if (!StringUtil.isBlank(accountNo)) {
            userPartition = StringUtil.substring(accountNo, 13, 15);
        }

        //�û�����ֱ�λ
        Random random = new Random();
        String userRadomPartition = StringUtil.alignRight(String.valueOf(random.nextInt(99)), 2,
            '0');

        return today + dataVersion + systemVersion + systemCode + bizCode + userPartition
               + userRadomPartition + realSeq;
    }

    /**
     * �����������������������������ţ�ȷ����ͬ�ķֿ�ֱ�λ������֧���������ܹ����й���ˮID�����ݼܹ��淶��׼��
     * <p>
     * ������ʽ������(8)+���ݰ汾(1)+ϵͳ�汾(1)+ϵͳ��ʶ��(3)+ҵ���ʶ��(3)+ҵ����չλ(��ѡ)+�û��ֱ�λ(2)+����û��ֱ�λ(2)+seq(8)
     * <br>
     * ���Ƹ�ʽ������(8)+���ݰ汾(1)+ϵͳ�汾(1)+ϵͳ��ʶ��(3)+ҵ���ʶ��(3)+ҵ����չλ(3)+ �û��ֱ�λ(2)+����û��ֱ�λ(2)+seq(8)
     * @param now           ��ǰʱ��
     * @param dataVersion   ���ݰ汾
     * @param systemVersion ϵͳ�汾
     * @param systemCode    ϵͳ��־��
     * @param bizCode       ҵ���־��
     * @param relatedKey    ��������
     * @param seq           ���к�
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
     * ��ȡ���������еİ汾λ��
     * 
     * @param key   ��������
     * @return      ���Ű汾λ
     */
    public static String getDataVersion(String key) {

        if (StringUtil.isBlank(key)) {

            return null;
        }

        String dataVersion = StringUtil.substring(key, VERSION_DB_KEY_START, VERSION_DB_KEY_END);

        return dataVersion;
    }

    /**
     * ����ת����
     *
     * @param date   ʱ��
     * @return       ����
     */
    public static String getPartition(Date date) {

        //ǰ8λyyyyMMdd��ʽ
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String partitionKey = dateFormat.format(date);
        return partitionKey;
    }
}
