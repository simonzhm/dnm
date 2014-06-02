/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.encrypter;

/**
 * 加密处理器接口
 * 
 * @author hongmin.zhonghm
 * @version $Id: Encrypter.java, v 0.1 2014-5-2 上午4:41:34 hongmin.zhonghm Exp $
 */
public interface Encrypter {

    /**
     * 加密处理
     */
    public String encrypt(String src);

}
