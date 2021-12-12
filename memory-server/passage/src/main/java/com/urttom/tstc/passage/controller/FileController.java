package com.urttom.tstc.passage.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.memory.utils.RestUtil;
import com.urttom.tstc.passage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/api/v1")
public class FileController {

    Log log = LogFactory.get();

    @Autowired
    private FileService fileService;

    @PutMapping("/bucket")
    public Object initBucket(){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), fileService.initBucket(), "请求成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "请求异常");
        }
    }

    @GetMapping("/file/{protocol}")
    public Object getFile(@PathVariable String protocol){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), fileService.getFile(protocol), "请求成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取异常");
        }
    }

    @PostMapping("/file")
    public Object uploadFile(MultipartFile file){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), fileService.uploadFile(file), "请求成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "上传异常");
        }
    }
}
