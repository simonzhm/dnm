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
 * 回调服务模版
 * 
 * @author hongmin.zhonghm
 * @version $Id: BizServiceCallBack.java, v 0.1 2014-5-2 下午5:56:12 hongmin.zhonghm Exp $
 */
public abstract class BizServiceCallBack<T, K, R> {
    /** 日志 */
    protected static final Logger LOGGER = Logger.getLogger(BizServiceCallBack.class);

    /** 回调方法参数 */
    private T                     parameter;

    /** 事物模版*/
    private TransactionTemplate   transactionTemplate;

    /**
     * 回调类构造函数
     * @param parameter 请求参数
     * @param transactionTemplate 如果不需要事务，则赋值为null
     */
    public BizServiceCallBack(T parameter, TransactionTemplate transactionTemplate) {
        this.parameter = parameter;
        this.transactionTemplate = transactionTemplate;
    }

    public final R callBack() {
        //初始化
        initContext();
        //执行
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
            //组装返回结果
            return composeResult(model, e);
        }
        //组装返回结果
        return composeResult(model, null);
    }

    /**
     * 初始化上下文
     */
    protected void initContext() {
        DnmContext context = DnmContextHolder.get();
        if (context == null) {
            Date now = new Date();
            DnmContextHolder.set(now);
        }
    }

    /**
     * 逻辑处理
     * 
     * @param parameter
     * @return
     */
    abstract protected K doCallBack(T pamateter);

    /**
     * 组装返回结果
     * 
     * @param model
     * @return
     */
    abstract protected R composeResult(K model, Exception e);
}
