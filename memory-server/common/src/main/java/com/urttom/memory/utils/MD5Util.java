package com.urttom.memory.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {

    /**
     * md5加密
     * @param source
     * @return
     */
    public static String encode(String source){
        return DigestUtils.md5DigestAsHex(source.getBytes());
    }
}
