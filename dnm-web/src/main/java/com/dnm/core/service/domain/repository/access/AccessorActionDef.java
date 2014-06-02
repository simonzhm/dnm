/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.access;

import java.util.ArrayList;
import java.util.List;

import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;

/**
 * 数据访问器动作定义
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccessorActionDef.java, v 0.1 2014-4-13 上午12:56:40 hongmin.zhonghm Exp $
 */
public class AccessorActionDef {
    /** 数据访问器动作定义 */
    List<AccessorSingleAction> accessorActionDef = new ArrayList<AccessorSingleAction>();

    /**
     * 增加动作
     * 
     * @param accessor
     * @param action
     */
    public void addAction(AccessorEnum accessor, RepoActionEnum action) {

        accessorActionDef.add(new AccessorSingleAction(accessor, action));
    }

    /**
     * 数据访问器单个动作定义
     * 
     * @author hongmin.zhonghm
     * @version $Id: AccessorSingleAction.java, v 0.1 2014-4-13 上午12:56:40 hongmin.zhonghm Exp $
     */
    public static class AccessorSingleAction {

        /** 数据访问器名称 */
        private final AccessorEnum   accessor;

        /** 数据访问器动作 */
        private final RepoActionEnum action;

        /**
         * 构造单个访问器动作
         * 
         * @param accessor
         * @param action
         */
        public AccessorSingleAction(AccessorEnum accessor, RepoActionEnum action) {
            super();
            this.accessor = accessor;
            this.action = action;
        }

        /** 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object o) {

            if (null == o) {
                return false;
            }

            if (!(o instanceof AccessorSingleAction)) {
                return false;
            }

            AccessorSingleAction other = (AccessorSingleAction) o;

            if (other.accessor == accessor && other.action == action) {
                return true;
            }

            return false;
        }

        /**
         * Getter method for property <tt>accessor</tt>.
         * 
         * @return property value of accessor
         */
        public AccessorEnum getAccessor() {
            return accessor;
        }

        /**
         * Getter method for property <tt>action</tt>.
         * 
         * @return property value of action
         */
        public RepoActionEnum getAction() {
            return action;
        }

    }

    /**
     * Getter method for property <tt>accessorActionDef</tt>.
     * 
     * @return property value of accessorActionDef
     */
    public List<AccessorSingleAction> getAccessorActionDef() {
        return accessorActionDef;
    }
}
