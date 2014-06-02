/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.AccountModel;

/**
 * �˻��������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountDomainService.java, v 0.1 2014-5-6 ����12:47:35 hongmin.zhonghm Exp $
 */
public interface AccountDomainService {

    /**
     * ����
     * 
     * @param model
     */
    public void openAccount(AccountModel model);

    /**
     * �����˻�
     * 
     * @param model
     */
    public void queryAccount(AccountModel model);
}
