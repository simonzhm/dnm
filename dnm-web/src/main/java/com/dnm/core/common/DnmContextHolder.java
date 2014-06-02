/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common;

import java.util.Date;

/**
 * 上下文容器
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmContextHolder.java, v 0.1 2014-4-14 下午9:51:01 hongmin.zhonghm Exp $
 */
public class DnmContextHolder {
    /** 本地线程 */
    private static ThreadLocal<DnmContext> contextLocal = new ThreadLocal<DnmContext>();

    /**
     * 私有构造方法，避免实例化
     */
    private DnmContextHolder() {
    }

    /**
     * 绑定上下文信息到当前线程
     * 
     * @param context 上下文信息
     */
    public static void set(DnmContext context) {
        contextLocal.set(context);
    }

    /**
     * 绑定上下文信息到当前线程
     * 
     * @param time 操作时间
     */
    public static void set(Date time) {
        set(new DnmContext(time));
    }

    /**
     * 获取当前上下文信息
     * 
     * @return 上下文信息
     */
    public static DnmContext get() {
        return contextLocal.get();
    }

    /**
     * 获取上下文操作时间
     * 
     * @return 上下文操作时间，如果当前线程没有绑定上下文则返回null
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
     * 清除当前现在中的上下文信息
     */
    public static void clear() {
        DnmContext context = contextLocal.get();
        if (context != null) {
            context.removeAllValues();
        }
        contextLocal.set(null);
    }
}
