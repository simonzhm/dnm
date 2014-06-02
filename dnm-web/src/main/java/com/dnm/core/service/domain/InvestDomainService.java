/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * 投标领域服务接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestDomainService.java, v 0.1 2014-5-25 下午6:48:37 hongmin.zhonghm Exp $
 */
public interface InvestDomainService {

    /**
     * 投标
     * 
     * @param model
     */
    public void invest(InvestRecordModel model);
}
