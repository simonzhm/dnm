/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.dnm.core.common.DnmContext;
import com.dnm.core.common.DnmContextHolder;

/**
 * �ص�����ģ��
 * 
 * @author hongmin.zhonghm
 * @version $Id: BizServiceCallBack.java, v 0.1 2014-5-2 ����5:56:12 hongmin.zhonghm Exp $
 */
public abstract class BizServiceCallBack<T, K, R> {
    /** ��־ */
    protected static final Logger LOGGER = Logger.getLogger(BizServiceCallBack.class);

    /** �ص��������� */
    private T                     parameter;

    /** ����ģ��*/
    private TransactionTemplate   transactionTemplate;

    /**
     * �ص��๹�캯��
     * @param parameter �������
     * @param transactionTemplate �������Ҫ������ֵΪnull
     */
    public BizServiceCallBack(T parameter, TransactionTemplate transactionTemplate) {
        this.parameter = parameter;
        this.transactionTemplate = transactionTemplate;
    }

    public final R callBack() {
        //��ʼ��
        initContext();
        //ִ��
        K model = null;
        try {
            if (transactionTemplate != null) {
                model = transactionTemplate.execute(new TransactionCallback<K>() {

                    /** 
                     * @see org.springframework.transaction.support.TransactionCallback#doInTransaction(org.springframework.transaction.TransactionStatus)
                     */
                    @Override
                    public K doInTransaction(TransactionStatus arg0) {
                        return doCallBack(parameter);
                    }

                });
            } else {
                model = doCallBack(parameter);
            }
        } catch (Exception e) {
            LOGGER.error(e);
            //��װ���ؽ��
            return composeResult(model, e);
        }
        //��װ���ؽ��
        return composeResult(model, null);
    }

    /**
     * ��ʼ��������
     */
    protected void initContext() {
        DnmContext context = DnmContextHolder.get();
        if (context == null) {
            Date now = new Date();
            DnmContextHolder.set(now);
        }
    }

    /**
     * �߼�����
     * 
     * @param parameter
     * @return
     */
    abstract protected K doCallBack(T pamateter);

    /**
     * ��װ���ؽ��
     * 
     * @param model
     * @return
     */
    abstract protected R composeResult(K model, Exception e);
}
