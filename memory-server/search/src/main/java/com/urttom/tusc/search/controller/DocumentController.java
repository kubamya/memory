package com.urttom.tusc.search.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.tusc.search.module.TstcPassage;
import com.urttom.tusc.search.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.urttom.memory.utils.RestUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document/api/v1")
public class DocumentController {

    Log log = LogFactory.get();

    @Autowired
    private DocumentService documentService;

    /**
     * 根据文章id删除文章
     * @param id
     * @return
     */
    @DeleteMapping("/passage/{id}")
    public Object deletePassageById(@PathVariable String id){
        try {
            documentService.deletePassageFromEs(id);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "删除成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "删除文章异常");
        }
    }

    /**
     * 根据id获取文章信息
     * @param id
     * @return
     */
    @GetMapping("/passage/{id}")
    public Object getPassageById(@PathVariable String id){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), documentService.getPassageFromEs(id), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取文章异常");
        }
    }

    /**
     * 新增文章、更新文章
     * @param passage
     * @return
     */
    @PutMapping("/passage")
    public Object putPassage(@RequestBody TstcPassage passage){
        try {
            documentService.addPassage(passage);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "新增成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "新增文章异常");
        }
    }
}
