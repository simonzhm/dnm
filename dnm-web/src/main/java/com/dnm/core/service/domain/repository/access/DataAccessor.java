/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access;

import com.dnm.core.service.domain.model.DomainModel;

/**
 * ���ݶ����������
 * <p>
 * ��Ҫ�ṩ���·���:
 * <ul>
 *  <li>������ģ����ȡ��ACCESSOR��Ӧ�����ݶ�����д洢
 *  <li>��ACCESSOR���������ݶ�����䵽ģ�Ͷ���
 * </ul>
 * ��ģ�Ͷ�����ȡ����Ӧ����
 * 
 * @author hongmin.zhonghm
 * @version $Id: DataAccessor.java, v 0.1 2014-4-13 ����12:40:14 hongmin.zhonghm Exp $
 */
public interface DataAccessor {
    /** ɾ����¼���� */
    public static final int DELETE_RECORD_NUM = 1;

    /** ���¼�¼���� */
    public static final int UPDATE_RECORD_NUM = 1;

    /**
     * ��������ģ�͡�
     *
     * @param model
     */
    public void store(DomainModel model);

    /**
     * ������º������ģ�͡�
     *
     * @param model
     */
    public void reStore(DomainModel model);

    /**
     * ����(ɾ��)������Ϣ��
     *
     * @param model
     */
    public void deprecate(DomainModel model);

    /**
     * ���ģ��
     * <p>
     * ע�⣺����<code>Collection</code>���Ͷ������䣬���뱣֤�ѳ�ʼ���������쳣
     *
     * @param model
     */
    public void fill(DomainModel model);

    /**
     * ������������¼�����ģ��
     * <p>
     * ע�⣺����<code>Collection</code>���Ͷ������䣬���뱣֤�ѳ�ʼ���������쳣
     *
     * @param model
     */
    public void lockFill(DomainModel model);

    /**
     * ���������ģ�ͣ�֧���ݵ�������ר�á��������Ӿ������ʵ�֡�
     *
     * @param model
     */
    public void reFill(DomainModel model);
}
