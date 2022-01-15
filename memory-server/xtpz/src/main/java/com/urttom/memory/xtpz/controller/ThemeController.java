package com.urttom.memory.xtpz.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.annotation.JwtToken;
import com.urttom.memory.utils.JwtUtil;
import com.urttom.memory.xtpz.module.TXtpzTheme;
import com.urttom.memory.xtpz.service.ThemeService;
import com.urttom.memory.utils.RestUtil;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/theme/api/v1")
public class ThemeController {

    Log log = LogFactory.get();

    @Autowired
    private ThemeService themeService;

    /**
     * 获取主题列表
     * @param current
     * @param total
     * @return
     */
    @JwtToken
    @GetMapping("/themes/current/{current}/total/{total}")
    public Object getThemes(@PathVariable int current, @PathVariable int total){
        try {
            return RestUtil.comRet(HttpStatus.SC_OK, themeService.getThemeList(new Page<>(current, total)), "查询成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "查询异常");
        }
    }

    /**
     * 根据id获取主题
     * @param id
     * @return
     */
    @JwtToken
    @GetMapping("/theme/{id}")
    public Object getThemeById(@PathVariable String id){
        try {
            return RestUtil.comRet(HttpStatus.SC_OK, themeService.getThemeById(id), "查询成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "查询异常");
        }
    }

    /**
     * 保存主题
     * @param tXtpzTheme
     * @return
     */
    @JwtToken
    @PostMapping("/theme")
    public Object saveTheme(@RequestBody TXtpzTheme tXtpzTheme, HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            String userId = JwtUtil.getUserId(token);
            themeService.saveTheme(tXtpzTheme, userId);
            return RestUtil.comRet(HttpStatus.SC_OK, null, "保存成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "保存异常");
        }
    }
}
