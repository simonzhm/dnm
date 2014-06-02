/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.common;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 线程上下文
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmContext.java, v 0.1 2014-4-14 下午5:50:36 hongmin.zhonghm Exp $
 */
public class DnmContext implements Serializable {

    private static final long   serialVersionUID = -9137977976899945092L;

    /** 操作时间（该时间取数据库服务器系统时间，不要手工设置） */
    private final Date          time;

    /** 存放上下文业务数据 */
    private Map<String, Object> contexts         = new HashMap<String, Object>();

    /**
     * 构造方法
     * 
     * @param time 操作时间
     */
    public DnmContext(Date time) {
        this.time = time;
    }

    /**
     * Getter method for property <tt>time</tt>.
     * 
     * @return property value of time
     */
    public Date getTime() {
        return time;
    }

    /**
     * 根据key获取线程中上下文的值
     * 
     * @param key
     * @return
     */
    public Object getValue(String key) {
        return contexts.get(key);
    }

    /**
     * 存放线程变量
     * 
     * @param key
     * @param value
     */
    public void addValue(String key, Object value) {
        contexts.put(key, value);
    }

    /**
     * 清楚所有线程上下文业务值
     */
    public void removeAllValues() {
        contexts.clear();
    }
}
