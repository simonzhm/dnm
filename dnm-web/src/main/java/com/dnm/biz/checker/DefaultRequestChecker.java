/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.checker;

import com.dnm.facade.request.BaseRequestOrder;

/**
 * 默认请求单据检查器，当请求单据无法匹配到定义的检验器时，将默认使用这个
 * 匹配规则：请求单据类+checker，如RegisterRequest -> RegisterRequestChecker
 * 
 * @author hongmin.zhonghm
 * @version $Id: DefaultRequestChecker.java, v 0.1 2014-4-29 下午9:18:02 hongmin.zhonghm Exp $
 */
public class DefaultRequestChecker extends BaseRequestChecker {

    /** 
     * @see com.dnm.biz.checker.BaseRequestChecker#doCheck(java.lang.Object)
     */
    @Override
    public void doCheck(BaseRequestOrder request) {

    }

}
