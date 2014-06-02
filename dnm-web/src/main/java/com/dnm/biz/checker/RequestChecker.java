/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.checker;

import com.dnm.facade.request.BaseRequestOrder;

/**
 * 参数检查器接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestChecker.java, v 0.1 2014-4-7 下午7:52:42 hongmin.zhonghm Exp $
 */
public interface RequestChecker {

    /**
     * 参数检查
     * 
     * @param request 请求单据
     */
    public void check(BaseRequestOrder request);
}
