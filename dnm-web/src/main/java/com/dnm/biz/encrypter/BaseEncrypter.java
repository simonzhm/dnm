/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.encrypter;

/**
 * 
 * @author hongmin.zhonghm
 * @version $Id: BaseEncrypter.java, v 0.1 2014-5-2 …œŒÁ4:42:57 hongmin.zhonghm Exp $
 */
public abstract class BaseEncrypter implements Encrypter {

    /** 
     * @see com.dnm.biz.encrypter.Encrypter#encrypt(java.lang.String)
     */
    @Override
    public String encrypt(String src) {
        return doEncrypt(src);
    }

    /**
     * º”√‹
     */
    public abstract String doEncrypt(String src);
}
