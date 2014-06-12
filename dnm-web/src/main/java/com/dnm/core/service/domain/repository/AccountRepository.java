/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * �˻��ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountRepository.java, v 0.1 2014-5-6 ����11:53:20 hongmin.zhonghm Exp $
 */
public interface AccountRepository {

    /**
     * �־û��˻�
     * 
     * @param model
     */
    public void store(AccountModel model);

    /**
     * �������ز����ģ��
     * 
     * @param model
     */
    public void fill(AccountModel model);

    /**
     * ���������ز����ģ��
     * 
     * @param model
     */
    public void reFill(AccountModel model);

    /**
     * ���ز����ģ�ͣ�������
     * 
     * @param model
     */
    public void active(AccountModel model);
}
