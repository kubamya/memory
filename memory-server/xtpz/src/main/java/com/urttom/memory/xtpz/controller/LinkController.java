package com.urttom.memory.xtpz.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.annotation.JwtToken;
import com.urttom.memory.utils.JwtUtil;
import com.urttom.memory.utils.RestUtil;
import com.urttom.memory.xtpz.module.TXtpzLink;
import com.urttom.memory.xtpz.service.LinkService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/link/api/v1")
public class LinkController {

    Log log = LogFactory.get();

    @Autowired
    private LinkService linkService;

    /**
     * 根据id获取链接信息
     * @param id
     * @return
     */
    @JwtToken
    @GetMapping("/link/{id}")
    public Object getLinkById(@PathVariable String id){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), linkService.getLinkById(id), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取链接异常");
        }
    }

    /**
     * 链接置无效
     * @param link
     * @param request
     * @return
     */
    @JwtToken
    @PutMapping("/link")
    public Object unableLink(@RequestBody TXtpzLink link, HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            String userId = JwtUtil.getUserId(token);

            link.setcUpdater(userId);

            if (StringUtils.equals(link.getcValid(), "2")) {
                linkService.enableLink(link);
            } else {
                linkService.unableLink(link);
            }
            return RestUtil.comRet(HttpStatus.OK.value(), null, "保存成功");
        } catch (Exception e){
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "保存链接异常");
        }
    }

    /**
     * 新增/更新链接
     * @param link
     * @param request
     * @return
     */
    @JwtToken
    @PostMapping("/link")
    public Object saveLink(@RequestBody TXtpzLink link, HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            String userId = JwtUtil.getUserId(token);

            if (StringUtils.isEmpty(link.getcId())) {
                link.setcCreator(userId);
                linkService.insertLink(link);
            } else {
                link.setcUpdater(userId);
                linkService.updateLink(link);
            }

            return RestUtil.comRet(HttpStatus.OK.value(), null, "保存成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "保存链接异常");
        }
    }

    /**
     * 分页获取链接
     * @param current
     * @param total
     * @return
     */
    @JwtToken
    @GetMapping("/links/current/{current}/total/{total}")
    public Object getLinks(@PathVariable int current, @PathVariable int total){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), linkService.getLinks(new Page<>(current, total)), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取链接异常");
        }
    }

    /**
     * 获取所有链接
     * @return
     */
    @GetMapping("/link/all")
    public Object getAllLinks(){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), linkService.getAllLinks(), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取链接异常");
        }
    }
}
