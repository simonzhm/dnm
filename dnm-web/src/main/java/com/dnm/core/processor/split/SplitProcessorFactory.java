/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import java.util.Map;

/**
 * 投标明细处理工厂
 * 
 * @author hongmin.zhonghm
 * @version $Id: SplitProcessorFactory.java, v 0.1 2014-5-27 下午1:30:13 hongmin.zhonghm Exp $
 */
public class SplitProcessorFactory {

    /** 拆标处理器集合 */
    private Map<String, SplitProcessor> processors;

    /**
     * 获取拆标处理器
     * 
     * @param repayMethod 还款方式
     * @return
     */
    public SplitProcessor getProcessor(String repayMethod) {
        return processors.get(repayMethod);
    }

    /**
     * Setter method for property <tt>processors</tt>.
     * 
     * @param processors value to be assigned to property processors
     */
    public void setProcessors(Map<String, SplitProcessor> processors) {
        this.processors = processors;
    }

}
