/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.checker;

import com.dnm.facade.request.BaseRequestOrder;

/**
 * ����������ӿ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: RequestChecker.java, v 0.1 2014-4-7 ����7:52:42 hongmin.zhonghm Exp $
 */
public interface RequestChecker {

    /**
     * �������
     * 
     * @param request ���󵥾�
     */
    public void check(BaseRequestOrder request);
}
