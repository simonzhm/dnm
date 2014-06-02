/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import com.dnm.core.service.domain.model.bill.InvestRecordModel;

/**
 * 拆分明细处理器接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: SplitProcessor.java, v 0.1 2014-5-25 下午10:48:13 hongmin.zhonghm Exp $
 */
public interface SplitProcessor {

    /**
     * 根据还款方式拆分明细，由各子类实现
     * 
     * @param mainRcd
     */
    public void split(InvestRecordModel mainRcd);
}
