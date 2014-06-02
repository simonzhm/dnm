/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.checker;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.facade.constant.AccountDirectionEnum;
import com.dnm.facade.constant.CurrencyEnum;
import com.dnm.facade.request.BaseRequestOrder;
import com.dnm.facade.request.OpenAccountRequest;

/**
 * 开户请求单据检查器
 * 
 * @author hongmin.zhonghm
 * @version $Id: OpenAccountRequestChecker.java, v 0.1 2014-5-6 上午12:18:58 hongmin.zhonghm Exp $
 */
public class OpenAccountRequestChecker extends BaseRequestChecker {

    /** 
     * @see com.dnm.biz.checker.BaseRequestChecker#doCheck(com.dnm.facade.request.BaseRequestOrder)
     */
    @Override
    public void doCheck(BaseRequestOrder requestData) {
        OpenAccountRequest request = (OpenAccountRequest) requestData;
        String currency = request.getCurrency();
        AssertUtil.notNull(CurrencyEnum.getByCode(currency), ResultCodeEnum.PARAM_ILLEGAL,
            "currency illegal:" + currency);
        String direction = request.getDirection();
        AssertUtil.notNull(AccountDirectionEnum.getByCode(direction), ResultCodeEnum.PARAM_ILLEGAL,
            "direction illegal:" + currency);
    }

}
