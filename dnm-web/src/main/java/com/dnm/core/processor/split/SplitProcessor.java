/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * �����ϸ�������ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: SplitProcessor.java, v 0.1 2014-5-25 ����10:48:13 hongmin.zhonghm Exp $
 */
public interface SplitProcessor {

    /**
     * ���ݻ��ʽ�����ϸ���ɸ�����ʵ��
     * 
     * @param mainRcd
     */
    public void split(InvestRecordModel mainRcd);
}
