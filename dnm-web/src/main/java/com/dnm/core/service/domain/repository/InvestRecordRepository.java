/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository;

import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * 投标记录领域仓储
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordRepositoryImpl.java, v 0.1 2014-5-25 下午7:23:11 hongmin.zhonghm Exp $
 */
public interface InvestRecordRepository {

    /** 持久化投标记录 */
    public void store(InvestRecordModel model);

}
