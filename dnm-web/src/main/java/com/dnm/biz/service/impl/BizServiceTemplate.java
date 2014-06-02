/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 业务服务模版类
 * 
 * @author hongmin.zhonghm
 * @version $Id: BizServiceTemplate.java, v 0.1 2014-5-2 下午5:29:47 hongmin.zhonghm Exp $
 */
public abstract class BizServiceTemplate {
    /** 日志 */
    protected static final Logger LOGGER = Logger.getLogger(BizServiceTemplate.class);

    /** 事务模板 */
    @Resource
    protected TransactionTemplate transactionTemplate;

    /**
     * 执行带事务服务
     * 
     * @param callBack 服务回调模版
     * @return
     */
    public <T, K, R> R execute(final BizServiceCallBack<T, K, R> callBack) {
        return callBack.callBack();
    }
}
