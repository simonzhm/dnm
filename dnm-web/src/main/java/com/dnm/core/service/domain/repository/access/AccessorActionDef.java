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
 * ���ݷ�������������
 * 
 * @author hongmin.zhonghm
 * @version $Id: AccessorActionDef.java, v 0.1 2014-4-13 ����12:56:40 hongmin.zhonghm Exp $
 */
public class AccessorActionDef {
    /** ���ݷ������������� */
    List<AccessorSingleAction> accessorActionDef = new ArrayList<AccessorSingleAction>();

    /**
     * ���Ӷ���
     * 
     * @param accessor
     * @param action
     */
    public void addAction(AccessorEnum accessor, RepoActionEnum action) {

        accessorActionDef.add(new AccessorSingleAction(accessor, action));
    }

    /**
     * ���ݷ�����������������
     * 
     * @author hongmin.zhonghm
     * @version $Id: AccessorSingleAction.java, v 0.1 2014-4-13 ����12:56:40 hongmin.zhonghm Exp $
     */
    public static class AccessorSingleAction {

        /** ���ݷ��������� */
        private final AccessorEnum   accessor;

        /** ���ݷ��������� */
        private final RepoActionEnum action;

        /**
         * ���쵥������������
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
