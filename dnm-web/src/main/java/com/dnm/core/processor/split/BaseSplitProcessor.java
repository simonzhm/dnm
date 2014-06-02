/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.processor.split;

import javax.annotation.Resource;

import com.dnm.core.service.SequenceService;

/**
 * 基础投标明细处理类
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseSplitProcessor.java, v 0.1 2014-5-27 上午12:22:10 hongmin.zhonghm Exp $
 */
public abstract class BaseSplitProcessor implements SplitProcessor {
    /** sequence服务 */
    @Resource
    protected SequenceService sequenceService;

}
