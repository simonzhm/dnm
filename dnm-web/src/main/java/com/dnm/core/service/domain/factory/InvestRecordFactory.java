/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.factory;

import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.facade.request.InvestRequest;

/**
 * Ͷ���¼���򹤳�
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordFactory.java, v 0.1 2014-5-15 ����1:08:34 hongmin.zhonghm Exp $
 */
public interface InvestRecordFactory {

    /**
     * ��װͶ���¼����ģ��
     * 
     * @param requestData
     * @return
     */
    public InvestRecordModel compose(InvestRequest requestData);
}
