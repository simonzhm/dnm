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
 * ���󵥾ݻ���У����
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseRequestChecker.java, v 0.1 2014-4-7 ����9:36:16 hongmin.zhonghm Exp $
 */
public abstract class BaseRequestChecker implements RequestChecker {

    /** ���󵥾ݻ��� */
    @Resource
    protected RequestOrderCache requestOrderCache;

    /** 
     * @see com.dnm.biz.checker.RequestChecker#check(com.dnm.facade.request.BaseRequestOrder)
     */
    @Override
    public void check(BaseRequestOrder requestData) {

        //���Էǿ�У��
        propertyCheck(requestData);

        //��������У��
        doCheck(requestData);
    }

    /**
     * ��������У�飬���ݸ���ҵ��ͬ����У��
     * 
     * @param requestData
     */
    public abstract void doCheck(BaseRequestOrder requestData);

    /**
     * ���Էǿ�У�飨���ȴ���0����ֻ�����ַ���
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
                //�����������
                field.setAccessible(true);
                //��ȡֵ
                Object value = field.get(requestData);

                //�ǿ�У��
                valueNotEmptyCheck(rc, fieldName, value, requestData);
                //����У��
                valueLengthCheck(rc, fieldName, value, requestData);
                //emailУ��
                valueEmailCheck(rc, fieldName, value, requestData);
                //����У��
                valueNumberCheck(rc, fieldName, value, requestData);
            } catch (Exception e) {
                AssertUtil.throwDnmException(ResultCodeEnum.PARAM_ILLEGAL, "[" + fieldName + "]"
                                                                           + e.getMessage());
            }
        }
    }

    /**
     * �ݹ�У��ǿ�����
     * 
     * @param rc ����ע��
     * @param name ������
     * @param value ����ֵ
     * @param request ���󵥾�
     */
    private void valueNotEmptyCheck(RequestFieldCheck rc, String name, Object value,
                                    BaseRequestOrder request) throws Exception {

        if (rc == null || !rc.notEmpty() && !rc.notNull())
            return;

        AssertUtil.notNull(value, ResultCodeEnum.PARAM_ILLEGAL, "is null");

        if (rc.notEmpty()) {
            //Ŀǰֻ����List<String>��List<BaseRequest>��String��BaseRequest
            if (value instanceof String) {
                AssertUtil.notBlank(value.toString(), ResultCodeEnum.PARAM_ILLEGAL,
                    "value is blank");
            } else if (value instanceof BaseRequestOrder) {
                BaseRequestOrder subRequest = (BaseRequestOrder) value;
                //�ݹ����
                propertyCheck(subRequest);
            } else if (value instanceof List) {
                List<?> listValue = (List<?>) value;
                AssertUtil.notEmpty(listValue, ResultCodeEnum.PARAM_ILLEGAL, "value is empty");

                for (Object obj : listValue) {
                    AssertUtil.isTrue(obj instanceof BaseRequestOrder,
                        ResultCodeEnum.PARAM_ILLEGAL,
                        "List field's generic type is not BaseRequest");
                    //�ݹ����
                    propertyCheck((BaseRequestOrder) obj);
                }
            } else {
                AssertUtil.throwDnmException(ResultCodeEnum.PARAM_ILLEGAL,
                    "property type must be List<String>,List<BaseRequest>,String or BaseRequest");
            }
        }
    }

    /**
     * ����У��
     * 
     * @param rc ����ע��
     * @param name ������
     * @param value ����ֵ
     * @param request ���󵥾�
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
     * emailУ��
     * 
     * @param rc ����ע��
     * @param name ������
     * @param value ����ֵ
     * @param request ���󵥾�
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
     * emailУ��
     * 
     * @param rc ����ע��
     * @param name ������
     * @param value ����ֵ
     * @param request ���󵥾�
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
