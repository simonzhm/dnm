/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.checker;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import com.dnm.core.cache.RequestOrderCache;
import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.common.util.ReflectionUtil;
import com.dnm.core.common.util.StringUtil;
import com.dnm.facade.anotation.RequestFieldCheck;
import com.dnm.facade.request.BaseRequestOrder;

/**
 * 请求单据基本校验类
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseRequestChecker.java, v 0.1 2014-4-7 下午9:36:16 hongmin.zhonghm Exp $
 */
public abstract class BaseRequestChecker implements RequestChecker {

    /** 请求单据缓存 */
    @Resource
    protected RequestOrderCache requestOrderCache;

    /** 
     * @see com.dnm.biz.checker.RequestChecker#check(com.dnm.facade.request.BaseRequestOrder)
     */
    @Override
    public void check(BaseRequestOrder requestData) {

        //属性非空校验
        propertyCheck(requestData);

        //个性请求校验
        doCheck(requestData);
    }

    /**
     * 个性请求校验，根据各种业务不同自行校验
     * 
     * @param requestData
     */
    public abstract void doCheck(BaseRequestOrder requestData);

    /**
     * 属性非空校验（长度大于0），只处理字符串
     * 
     * @param requestData
     */
    private void propertyCheck(BaseRequestOrder requestData) {
        RequestFieldCheck rc = null;
        String fieldName = null;

        String requestOrderName = ReflectionUtil.getFullName(requestData);

        List<Field> anotationFiles = requestOrderCache.getCheckField(requestOrderName);

        for (Field field : anotationFiles) {
            rc = field.getAnnotation(RequestFieldCheck.class);
            try {

                fieldName = field.getName();
                //设置允许访问
                field.setAccessible(true);
                //获取值
                Object value = field.get(requestData);

                //非空校验
                valueNotEmptyCheck(rc, fieldName, value, requestData);
                //长度校验
                valueLengthCheck(rc, fieldName, value, requestData);
                //email校验
                valueEmailCheck(rc, fieldName, value, requestData);
                //数字校验
                valueNumberCheck(rc, fieldName, value, requestData);
            } catch (Exception e) {
                AssertUtil.throwDnmException(ResultCodeEnum.PARAM_ILLEGAL, "[" + fieldName + "]"
                                                                           + e.getMessage());
            }
        }
    }

    /**
     * 递归校验非空属性
     * 
     * @param rc 属性注解
     * @param name 属性名
     * @param value 属性值
     * @param request 请求单据
     */
    private void valueNotEmptyCheck(RequestFieldCheck rc, String name, Object value,
                                    BaseRequestOrder request) throws Exception {

        if (rc == null || !rc.notEmpty() && !rc.notNull())
            return;

        AssertUtil.notNull(value, ResultCodeEnum.PARAM_ILLEGAL, "is null");

        if (rc.notEmpty()) {
            //目前只接受List<String>，List<BaseRequest>，String，BaseRequest
            if (value instanceof String) {
                AssertUtil.notBlank(value.toString(), ResultCodeEnum.PARAM_ILLEGAL,
                    "value is blank");
            } else if (value instanceof BaseRequestOrder) {
                BaseRequestOrder subRequest = (BaseRequestOrder) value;
                //递归调用
                propertyCheck(subRequest);
            } else if (value instanceof List) {
                List<?> listValue = (List<?>) value;
                AssertUtil.notEmpty(listValue, ResultCodeEnum.PARAM_ILLEGAL, "value is empty");

                for (Object obj : listValue) {
                    AssertUtil.isTrue(obj instanceof BaseRequestOrder,
                        ResultCodeEnum.PARAM_ILLEGAL,
                        "List field's generic type is not BaseRequest");
                    //递归调用
                    propertyCheck((BaseRequestOrder) obj);
                }
            } else {
                AssertUtil.throwDnmException(ResultCodeEnum.PARAM_ILLEGAL,
                    "property type must be List<String>,List<BaseRequest>,String or BaseRequest");
            }
        }
    }

    /**
     * 长度校验
     * 
     * @param rc 属性注解
     * @param name 属性名
     * @param value 属性值
     * @param request 请求单据
     */
    private void valueLengthCheck(RequestFieldCheck rc, String name, Object value,
                                  BaseRequestOrder request) throws Exception {
        if (rc == null || (rc.minLength() == 0 && rc.maxLength() == 0 && rc.length() == 0))
            return;

        AssertUtil.notNull(value, ResultCodeEnum.PARAM_ILLEGAL, "is null");

        AssertUtil.isTrue(value instanceof String, ResultCodeEnum.PARAM_ILLEGAL,
            "illegal type, expect String");

        String strValue = (String) value;

        if (rc.length() > 0) {
            AssertUtil.isTrue(StringUtil.isMeetLength(strValue, rc.length()),
                ResultCodeEnum.PARAM_ILLEGAL, "not meet length, expect " + rc.length());
        } else if (rc.minLength() > 0) {
            AssertUtil.isTrue(StringUtil.isMeetMinLength(strValue, rc.minLength()),
                ResultCodeEnum.PARAM_ILLEGAL, "not meet min length, expect " + rc.minLength());
        } else if (rc.maxLength() > 0) {
            AssertUtil.isTrue(StringUtil.isMeetMaxLength(strValue, rc.maxLength()),
                ResultCodeEnum.PARAM_ILLEGAL, "not meet max length, expect " + rc.maxLength());
        }

    }

    /**
     * email校验
     * 
     * @param rc 属性注解
     * @param name 属性名
     * @param value 属性值
     * @param request 请求单据
     */
    private void valueEmailCheck(RequestFieldCheck rc, String name, Object value,
                                 BaseRequestOrder request) throws Exception {
        if (rc == null || !rc.isEmail())
            return;

        AssertUtil.notNull(value, ResultCodeEnum.PARAM_ILLEGAL, "is null");

        AssertUtil.isTrue(value instanceof String, ResultCodeEnum.PARAM_ILLEGAL,
            "illegal type, expect String");

        String strValue = (String) value;

        AssertUtil.isTrue(StringUtil.isEmail(strValue), ResultCodeEnum.PARAM_ILLEGAL,
            "is not email format[xxx@163.com]");
    }

    /**
     * email校验
     * 
     * @param rc 属性注解
     * @param name 属性名
     * @param value 属性值
     * @param request 请求单据
     */
    private void valueNumberCheck(RequestFieldCheck rc, String name, Object value,
                                  BaseRequestOrder request) throws Exception {
        if (rc == null || (!rc.positive() && !rc.integer()))
            return;

        AssertUtil.notNull(value, ResultCodeEnum.PARAM_ILLEGAL, "is null");

        BigDecimal numValue = new BigDecimal(value.toString());
        BigDecimal zeroValue = new BigDecimal(0);

        if (rc.positive()) {
            AssertUtil.isTrue(numValue.compareTo(zeroValue) > 0, ResultCodeEnum.PARAM_ILLEGAL,
                "value must greater than 0");
        }

        if (rc.integer()) {
            AssertUtil.isTrue(numValue.compareTo(zeroValue) >= 0, ResultCodeEnum.PARAM_ILLEGAL,
                "value must greater than or equals 0");
        }
    }
}
