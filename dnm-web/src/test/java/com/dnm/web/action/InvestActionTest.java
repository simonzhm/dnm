/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.web.action;

import com.opensymphony.xwork2.ActionProxy;

/**
 * 投标测试类
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestActionTest.java, v 0.1 2014-4-11 上午1:54:26 hongmin.zhonghm Exp $
 */
public class InvestActionTest extends BaseActionTest {
    private InvestAction action;
    private ActionProxy  proxy;

    private void init() {
        proxy = getActionProxy("/biz/invest");
        action = (InvestAction) proxy.getAction();
        assertNotNull(action);
    }

    public void testAdd() throws Exception {
        init();
        proxy.execute();
    }
}
