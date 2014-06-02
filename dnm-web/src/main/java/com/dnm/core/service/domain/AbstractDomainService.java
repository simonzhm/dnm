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
 * 基础领域服务
 * 
 * @author hongmin.zhonghm
 * @version $Id: AbstractDomainService.java, v 0.1 2014-4-13 上午3:03:32 hongmin.zhonghm Exp $
 */
public class AbstractDomainService {

    /** 数据对象访问器容器 */
    @Resource
    private Map<String, DataAccessor> dataAccessorContainer = new HashMap<String, DataAccessor>();

    /** sequence服务 */
    @Resource
    protected SequenceService         sequenceService;

    /**
     * 存储操作定义
     * 
     * @return
     */
    protected AccessorActionDef defAction(AccessorEnum accessor, RepoActionEnum action) {
        AccessorActionDef actionDef = new AccessorActionDef();

        actionDef.addAction(accessor, action);

        return actionDef;
    }

    /**
     * 根据仓储操作类型操作模型
     *
     * @param model             领域模型
     * @param accessorActions   设定的数据对象访问器集合和动作
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
     * 根据数据访问器名称获取访问器
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
     * 使用具体数据对象访问器操作模型
     *
     * @param model           领域模型
     * @param dataAccessor         数据对象访问器
     * @param operateEnum           模型操作类型
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
