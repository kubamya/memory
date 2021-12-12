package com.urttom.memory.utils;

import java.util.HashMap;
import java.util.Map;

public class RestUtil {

    public static Map<String, Object> comRet(int code, Object data, String msg){
        return new HashMap<String, Object>(){{
            put("code", code);
            put("data", data);
            put("msg", msg);
        }};
    }
}
