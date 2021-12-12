package com.urttom.tusc.search.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.tusc.search.service.InitService;
import com.urttom.tusc.search.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init/api/v1")
public class InitController {

    Log log = LogFactory.get();

    @Autowired
    private InitService initService;

    /**
     * 初始化索引库
     * @return
     */
    @GetMapping("/mappings")
    public Object initMapping() {
        try {
            initService.initPassageMapping();
            return RestUtil.comRet(HttpStatus.OK.value(), null, "初始化成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "初始化异常");
        }
    }
}
