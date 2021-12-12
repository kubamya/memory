package com.urttom.memory.xtpz.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.memory.xtpz.module.TXtpzBroadcast;
import com.urttom.memory.xtpz.service.BroadcastService;
import com.urttom.memory.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broadcast/api/v1")
public class BroadcastController {

    Log log = LogFactory.get();

    @Autowired
    private BroadcastService broadcastService;

    @PutMapping("/broadcast")
    public Object updateBroadcast(@RequestBody TXtpzBroadcast broadcast){
        try {
            broadcastService.updateBroadcast(broadcast);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "修改成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "修改异常");
        }
    }

    @PostMapping("/broadcast")
    public Object addBroadcast(@RequestBody TXtpzBroadcast broadcast){
        try {
            broadcastService.addBroadcast(broadcast);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "保存成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "保存异常");
        }
    }
}
