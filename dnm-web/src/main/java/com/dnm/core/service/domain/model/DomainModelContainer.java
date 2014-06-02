/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.model;

/**
 * 领域模型容器，用于暂时存放模型对象，使用泛型参数表示真正要保存的对象类型
 * 
 * @author hongmin.zhonghm
 * @version $Id: DomainModelContainer.java, v 0.1 2014-4-13 上午1:14:41 hongmin.zhonghm Exp $
 */
public class DomainModelContainer<T> {
    /** 领域模型对象 */
    private T model;

    /**
     * 默认无参构造方法
     */
    public DomainModelContainer() {
    }

    /**
     * 容器构造方法，保持指定领域模型对象
     * 
     * @param model 领域模型对象
     */
    public DomainModelContainer(T model) {
        this.model = model;
    }

    /**
     * 获取容器中保存的领域模型对象
     * 
     * @return 领域模型对象
     */
    public T getModel() {
        return model;
    }

    /**
     * 设置容器中存放的领域模型对象
     * 
     * @param model 领域模型对象
     */
    public void setModel(T model) {
        this.model = model;
    }
}
