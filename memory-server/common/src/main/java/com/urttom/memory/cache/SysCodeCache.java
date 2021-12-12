package com.urttom.memory.cache;

import com.alibaba.fastjson.JSON;
import com.urttom.memory.module.TSysCode;
import com.urttom.memory.service.TSysCodeService;
import com.urttom.memory.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 单值代码缓存
 */
@Component
public class SysCodeCache {

    @Autowired
    private TSysCodeService tSysCodeService;

    @Autowired
    private RedisUtil redisUtil;

    public void init(){
        List<TSysCode> allCodes = tSysCodeService.getAllCodes();
        redisUtil.add("allCodes", JSON.toJSONString(allCodes));
    }
}
