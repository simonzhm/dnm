/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.InvestDomainService;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * Ͷ���������
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestDomainServiceImpl.java, v 0.1 2014-5-25 ����6:50:09 hongmin.zhonghm Exp $
 */
public class InvestDomainServiceImpl extends AbstractDomainService implements InvestDomainService {

    /** 
     * @see com.dnm.core.service.domain.InvestDomainService#invest(com.dnm.core.service.domain.model.bill.InvestRecordModel)
     */
    @Override
    public void invest(InvestRecordModel model) {
        //��ϸ��
        splitDueinRcd(model);
    }

    /**
     * ��Ͷ�ʷ�ʽ�����ϸ��
     * 
     * @param model
     */
    private void splitDueinRcd(InvestRecordModel model) {

    }
}
