/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import java.util.Map;

/**
 * Ͷ����ϸ������
 * 
 * @author hongmin.zhonghm
 * @version $Id: SplitProcessorFactory.java, v 0.1 2014-5-27 ����1:30:13 hongmin.zhonghm Exp $
 */
public class SplitProcessorFactory {

    /** ��괦�������� */
    private Map<String, SplitProcessor> processors;

    /**
     * ��ȡ��괦����
     * 
     * @param repayMethod ���ʽ
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
