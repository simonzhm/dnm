/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import javax.annotation.Resource;

import com.dnm.core.service.SequenceService;

/**
 * ����Ͷ����ϸ������
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseSplitProcessor.java, v 0.1 2014-5-27 ����12:22:10 hongmin.zhonghm Exp $
 */
public abstract class BaseSplitProcessor implements SplitProcessor {
    /** sequence���� */
    @Resource
    protected SequenceService sequenceService;

}
