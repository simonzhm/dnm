/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.encrypter;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: EncrypterFactory.java, v 0.1 2014-5-2 ����4:54:05 hongmin.zhonghm Exp $
 */
public class EncrypterFactory {

    private Map<String, Encrypter> encrypterMap = new HashMap<String, Encrypter>();

    /**
     * ���ݸ�ʽ�����ƻ�ȡ������
     * 
     * @param formatName
     * @return
     */
    public Encrypter getEncrypter(String formatName) {
        return encrypterMap.get(formatName);
    }

    /**
     * Setter method for property <tt>encrypterMap</tt>.
     * 
     * @param encrypterMap value to be assigned to property encrypterMap
     */
    public void setEncrypterMap(Map<String, Encrypter> encrypterMap) {
        this.encrypterMap = encrypterMap;
    }

}
