/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.AccountTransLogModel;

/**
 * �˻�������־�ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountRepository.java, v 0.1 2014-5-6 ����11:53:20 hongmin.zhonghm Exp $
 */
public interface AccountTransLogRepository {

    /**
     * �־û��˻�������־
     * 
     * @param model
     */
    public void store(AccountTransLogModel model);
}
