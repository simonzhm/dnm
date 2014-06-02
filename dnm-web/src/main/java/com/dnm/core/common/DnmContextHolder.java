/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common;

import java.util.Date;

/**
 * ����������
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmContextHolder.java, v 0.1 2014-4-14 ����9:51:01 hongmin.zhonghm Exp $
 */
public class DnmContextHolder {
    /** �����߳� */
    private static ThreadLocal<DnmContext> contextLocal = new ThreadLocal<DnmContext>();

    /**
     * ˽�й��췽��������ʵ����
     */
    private DnmContextHolder() {
    }

    /**
     * ����������Ϣ����ǰ�߳�
     * 
     * @param context ��������Ϣ
     */
    public static void set(DnmContext context) {
        contextLocal.set(context);
    }

    /**
     * ����������Ϣ����ǰ�߳�
     * 
     * @param time ����ʱ��
     */
    public static void set(Date time) {
        set(new DnmContext(time));
    }

    /**
     * ��ȡ��ǰ��������Ϣ
     * 
     * @return ��������Ϣ
     */
    public static DnmContext get() {
        return contextLocal.get();
    }

    /**
     * ��ȡ�����Ĳ���ʱ��
     * 
     * @return �����Ĳ���ʱ�䣬�����ǰ�߳�û�а��������򷵻�null
     */
    public static Date getTime() {
        DnmContext context = contextLocal.get();
        if (context != null) {
            return context.getTime();
        } else {
            return null;
        }
    }

    /**
     * �����ǰ�����е���������Ϣ
     */
    public static void clear() {
        DnmContext context = contextLocal.get();
        if (context != null) {
            context.removeAllValues();
        }
        contextLocal.set(null);
    }
}
