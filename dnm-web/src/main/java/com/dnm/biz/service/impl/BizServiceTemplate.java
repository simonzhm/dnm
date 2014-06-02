/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * ҵ�����ģ����
 * 
 * @author hongmin.zhonghm
 * @version $Id: BizServiceTemplate.java, v 0.1 2014-5-2 ����5:29:47 hongmin.zhonghm Exp $
 */
public abstract class BizServiceTemplate {
    /** ��־ */
    protected static final Logger LOGGER = Logger.getLogger(BizServiceTemplate.class);

    /** ����ģ�� */
    @Resource
    protected TransactionTemplate transactionTemplate;

    /**
     * ִ�д��������
     * 
     * @param callBack ����ص�ģ��
     * @return
     */
    public <T, K, R> R execute(final BizServiceCallBack<T, K, R> callBack) {
        return callBack.callBack();
    }
}
