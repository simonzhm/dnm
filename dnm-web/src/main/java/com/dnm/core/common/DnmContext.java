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
 * �߳�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmContext.java, v 0.1 2014-4-14 ����5:50:36 hongmin.zhonghm Exp $
 */
public class DnmContext implements Serializable {

    private static final long   serialVersionUID = -9137977976899945092L;

    /** ����ʱ�䣨��ʱ��ȡ���ݿ������ϵͳʱ�䣬��Ҫ�ֹ����ã� */
    private final Date          time;

    /** ���������ҵ������ */
    private Map<String, Object> contexts         = new HashMap<String, Object>();

    /**
     * ���췽��
     * 
     * @param time ����ʱ��
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
     * ����key��ȡ�߳��������ĵ�ֵ
     * 
     * @param key
     * @return
     */
    public Object getValue(String key) {
        return contexts.get(key);
    }

    /**
     * ����̱߳���
     * 
     * @param key
     * @param value
     */
    public void addValue(String key, Object value) {
        contexts.put(key, value);
    }

    /**
     * ��������߳�������ҵ��ֵ
     */
    public void removeAllValues() {
        contexts.clear();
    }
}
