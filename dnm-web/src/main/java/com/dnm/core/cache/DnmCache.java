/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.cache;

/**
 * ����ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: DnmCache.java, v 0.1 2014-4-30 ����9:50:45 hongmin.zhonghm Exp $
 */
public interface DnmCache {

    /**
     * ��ʼ������
     */
    public void init() throws Exception;

    /**
     * ��ջ���
     */
    public void clear() throws Exception;

    /**
     * ��ȡ������
     * 
     * @return
     */
    public String getName();

    /**
     * ��ӡ������Ϣ
     */
    public void dump();
}
