/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.checker;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.facade.constant.AccountTransCodeEnum;
import com.dnm.facade.constant.InterestRateTypeEnum;
import com.dnm.facade.request.BaseRequestOrder;
import com.dnm.facade.request.InvestPriceCostRequest;
import com.dnm.facade.request.InvestRequest;

/**
 * 投标记录检查器
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRequestChecker.java, v 0.1 2014-5-15 下午10:16:51 hongmin.zhonghm Exp $
 */
public class InvestRequestChecker extends BaseRequestChecker {

    /** 
     * @see com.dnm.biz.checker.BaseRequestChecker#doCheck(com.dnm.facade.request.BaseRequestOrder)
     */
    @Override
    public void doCheck(BaseRequestOrder requestData) {
        InvestRequest request = (InvestRequest) requestData;

        AssertUtil.equals(request.getInterestRateType(), InterestRateTypeEnum.YEAR.getCode(),
            ResultCodeEnum.PARAM_ILLEGAL,
            "interest rate type must be " + InterestRateTypeEnum.YEAR.getCode());

        String tmpType = null;
        //如果奖励列表不为空
        List<InvestPriceCostRequest> priceList = request.getInvestPriceList();
        if (!CollectionUtils.isEmpty(priceList)) {
            for (InvestPriceCostRequest price : priceList) {
                tmpType = StringUtil.substring(price.getType(), 0, 2);
                AssertUtil.notBlank(price.getType(), ResultCodeEnum.PARAM_ILLEGAL,
                    "price type is empty");
                AssertUtil.isTrue(
                    AccountTransCodeEnum.getByCode(tmpType) == AccountTransCodeEnum.INCOME,
                    ResultCodeEnum.PARAM_ILLEGAL, "price main type is illegal, except:"
                                                  + AccountTransCodeEnum.INCOME.getCode()
                                                  + ",actual:" + tmpType);
                AssertUtil.isFalse(
                    (StringUtil.isBlank(price.getRate()) || StringUtil.isBlank(price.getOrigAmt()))
                            && StringUtil.isBlank(price.getActualAmt()),
                    ResultCodeEnum.PARAM_ILLEGAL,
                    "rate or  and origAmt and rate or actualAmt can't not be empty both");
            }
        }

        //如果费用列表不为空
        List<InvestPriceCostRequest> costList = request.getInvestCostList();
        if (!CollectionUtils.isEmpty(costList)) {
            for (InvestPriceCostRequest cost : costList) {
                tmpType = StringUtil.substring(cost.getType(), 0, 2);
                AssertUtil.notBlank(cost.getType(), ResultCodeEnum.PARAM_ILLEGAL, "type is empty");
                AssertUtil.isTrue(
                    AccountTransCodeEnum.getByCode(tmpType) == AccountTransCodeEnum.COST,
                    ResultCodeEnum.PARAM_ILLEGAL, "price main type is illegal, except:"
                                                  + AccountTransCodeEnum.COST.getCode()
                                                  + ",actual:" + tmpType);
                AssertUtil.isFalse(
                    (StringUtil.isBlank(cost.getRate()) || StringUtil.isBlank(cost.getOrigAmt()))
                            && StringUtil.isBlank(cost.getActualAmt()),
                    ResultCodeEnum.PARAM_ILLEGAL,
                    "rate or  and origAmt and rate or actualAmt can't not be empty both");
            }
        }
    }
}
