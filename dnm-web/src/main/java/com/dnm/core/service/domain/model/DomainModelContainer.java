/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model;

/**
 * ����ģ��������������ʱ���ģ�Ͷ���ʹ�÷��Ͳ�����ʾ����Ҫ����Ķ�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: DomainModelContainer.java, v 0.1 2014-4-13 ����1:14:41 hongmin.zhonghm Exp $
 */
public class DomainModelContainer<T> {
    /** ����ģ�Ͷ��� */
    private T model;

    /**
     * Ĭ���޲ι��췽��
     */
    public DomainModelContainer() {
    }

    /**
     * �������췽��������ָ������ģ�Ͷ���
     * 
     * @param model ����ģ�Ͷ���
     */
    public DomainModelContainer(T model) {
        this.model = model;
    }

    /**
     * ��ȡ�����б��������ģ�Ͷ���
     * 
     * @return ����ģ�Ͷ���
     */
    public T getModel() {
        return model;
    }

    /**
     * ���������д�ŵ�����ģ�Ͷ���
     * 
     * @param model ����ģ�Ͷ���
     */
    public void setModel(T model) {
        this.model = model;
    }
}
