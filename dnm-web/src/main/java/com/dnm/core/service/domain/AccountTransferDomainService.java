/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.AccountTransLogModel;

/**
 * �˻�������־�������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccountTransferDomainService.java, v 0.1 2014-5-6 ����12:47:35 hongmin.zhonghm Exp $
 */
public interface AccountTransferDomainService {

    /**
     * ת�ˣ���Ӧ���˻�����ΪD��
     * 
     * @param model
     */
    public void accountTransfer(AccountTransLogModel model);
}
