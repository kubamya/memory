package com.urttom.memory.xtpz.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.annotation.JwtToken;
import com.urttom.memory.xtpz.module.TXtpzTheme;
import com.urttom.memory.xtpz.service.ThemeService;
import com.urttom.memory.utils.RestUtil;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 删除主题
     * @param id
     * @return
     */
    @DeleteMapping("/theme/{id}")
    public Object updateTheme(@PathVariable String id) {
        try {
            themeService.deleteTheme(id);
            return RestUtil.comRet(HttpStatus.SC_OK, null, "删除成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "删除异常");
        }
    }

    /**
     * 修改主题
     * @param tXtpzTheme
     * @return
     */
    @PutMapping("/theme")
    public Object updateTheme(@RequestBody TXtpzTheme tXtpzTheme) {
        try {
            themeService.updateTheme(tXtpzTheme);
            return RestUtil.comRet(HttpStatus.SC_OK, null, "修改成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "修改异常");
        }
    }

    /**
     * 添加主题
     * @param tXtpzTheme
     * @return
     */
    @PostMapping("/theme")
    public Object addTheme(@RequestBody TXtpzTheme tXtpzTheme){
        try {
            themeService.addTheme(tXtpzTheme);
            return RestUtil.comRet(HttpStatus.SC_OK, null, "保存成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.SC_INTERNAL_SERVER_ERROR, e, "保存异常");
        }
    }
}
