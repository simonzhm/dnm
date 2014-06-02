/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.dnm.core.common.resultcode.ResultCodeEnum;
import com.dnm.core.common.util.AssertUtil;
import com.dnm.core.service.SequenceService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.DomainModel;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;
import com.dnm.core.service.domain.repository.access.DataAccessor;

/**
 * �����������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AbstractDomainService.java, v 0.1 2014-4-13 ����3:03:32 hongmin.zhonghm Exp $
 */
public class AbstractDomainService {

    /** ���ݶ������������ */
    @Resource
    private Map<String, DataAccessor> dataAccessorContainer = new HashMap<String, DataAccessor>();

    /** sequence���� */
    @Resource
    protected SequenceService         sequenceService;

    /**
     * �洢��������
     * 
     * @return
     */
    protected AccessorActionDef defAction(AccessorEnum accessor, RepoActionEnum action) {
        AccessorActionDef actionDef = new AccessorActionDef();

        actionDef.addAction(accessor, action);

        return actionDef;
    }

    /**
     * ���ݲִ��������Ͳ���ģ��
     *
     * @param model             ����ģ��
     * @param accessorActions   �趨�����ݶ�����������ϺͶ���
     */
    protected void accessModel(DomainModel model, AccessorActionDef accessorActionDef) {

        AssertUtil.notNull(model, ResultCodeEnum.SYSTEM_ERROR, "domainModel must not be null");

        for (AccessorActionDef.AccessorSingleAction accessorSingleAction : accessorActionDef
            .getAccessorActionDef()) {

            DataAccessor accessor = fetchAccessor(accessorSingleAction.getAccessor().getCode());

            excuteAccessors(model, accessor, accessorSingleAction.getAction());
        }
    }

    /**
     * �������ݷ��������ƻ�ȡ������
     *
     * @param accessorName
     * @return
     */
    private DataAccessor fetchAccessor(String accessorName) {

        DataAccessor dataAccessor = dataAccessorContainer.get(accessorName);

        AssertUtil.notNull(accessorName, ResultCodeEnum.SYSTEM_ERROR, "accessor[" + accessorName
                                                                      + "] not defined");

        return dataAccessor;
    }

    /**
     * ʹ�þ������ݶ������������ģ��
     *
     * @param model           ����ģ��
     * @param dataAccessor         ���ݶ��������
     * @param operateEnum           ģ�Ͳ�������
     */
    private void excuteAccessors(DomainModel model, DataAccessor dataAccessor,
                                 RepoActionEnum operateEnum) {
        switch (operateEnum) {
            case STORE:
                dataAccessor.store(model);
                break;
            case RESTORE:
                dataAccessor.reStore(model);
                break;
            case DEPRECATE:
                dataAccessor.deprecate(model);
                break;
            case ACTIVE:
                dataAccessor.lockFill(model);
                break;
            case LOAD:
                dataAccessor.fill(model);
                break;
            case RELOAD:
                dataAccessor.reFill(model);
                break;
            default:
                AssertUtil.throwDnmException(ResultCodeEnum.SYSTEM_ERROR,
                    "unkown repository operation");
        }
    }

    /**
     * Getter method for property <tt>dataAccessorContainer</tt>.
     * 
     * @return property value of dataAccessorContainer
     */
    public Map<String, DataAccessor> getDataAccessorContainer() {
        return dataAccessorContainer;
    }

    /**
     * Setter method for property <tt>dataAccessorContainer</tt>.
     * 
     * @param dataAccessorContainer value to be assigned to property dataAccessorContainer
     */
    public void setDataAccessorContainer(Map<String, DataAccessor> dataAccessorContainer) {
        this.dataAccessorContainer = dataAccessorContainer;
    }

}
