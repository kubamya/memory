package com.urttom.memory.passage.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.memory.annotation.JwtToken;
import com.urttom.memory.passage.module.TPassage;
import com.urttom.memory.passage.service.PassageService;
import com.urttom.memory.utils.JwtUtil;
import com.urttom.memory.utils.RestUtil;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/passage/api/v1")
public class PassageController {

    Log log = LogFactory.get();

    @Autowired
    private PassageService passageService;

    @GetMapping("/passageList/pageNum/{pageNum}/pageSize/{pageSize}")
    public Object getPassageList(@PathVariable int pageNum, @PathVariable int pageSize){
        try {
            return RestUtil.comRet(HttpStatus.SC_OK, passageService.getPassageList(pageNum, pageSize), "查询成功");
        } catch (Exception e){
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "获取文章列表异常");
        }
    }

    /**
     * 获取首页主题列表
     * @return
     */
    @GetMapping("/themeList")
    public Object getThemeList(){
        try {
            return RestUtil.comRet(HttpStatus.SC_OK, passageService.getThemeList(), "查询成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "获取主题列表异常");
        }
    }

    /**
     * 发布文章
     * @param passage
     * @param request
     * @return
     */
    @JwtToken
    @PostMapping("/passage/publish")
    public Object publishPassage(@RequestBody TPassage passage, HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            String userId = JwtUtil.getUserId(token);
            passageService.publishPassage(passage, userId);
            return RestUtil.comRet(HttpStatus.SC_OK, null, "查询成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "文章发布异常");
        }
    }
}
