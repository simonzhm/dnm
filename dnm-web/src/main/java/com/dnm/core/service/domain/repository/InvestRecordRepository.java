/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * Ͷ���¼����ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordRepositoryImpl.java, v 0.1 2014-5-25 ����7:23:11 hongmin.zhonghm Exp $
 */
public interface InvestRecordRepository {

    /** �־û�Ͷ���¼ */
    public void store(InvestRecordModel model);

}
