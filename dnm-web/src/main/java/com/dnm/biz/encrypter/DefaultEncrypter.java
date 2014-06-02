/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.biz.encrypter;

import com.dnm.core.common.util.MD5Util;

/**
 * 默认加密器，即全部加密，如密码
 * 
 * @author hongmin.zhonghm
 * @version $Id: DefaultEncrypter.java, v 0.1 2014-5-2 上午4:52:38 hongmin.zhonghm Exp $
 */
public class DefaultEncrypter extends BaseEncrypter {

    /** 
     * @see com.dnm.biz.encrypter.BaseEncrypter#doEncrypt(java.lang.String)
     */
    @Override
    public String doEncrypt(String src) {
        return MD5Util.getCode(src);
    }

}
