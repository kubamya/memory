package com.urttom.memory.xtpz.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.annotation.JwtToken;
import com.urttom.memory.utils.JwtUtil;
import com.urttom.memory.xtpz.module.TXtpzLabel;
import com.urttom.memory.xtpz.service.LabelService;
import com.urttom.memory.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/label/api/v1")
public class LabelController {

    Log log = LogFactory.get();

    @Autowired
    private LabelService labelService;

    @JwtToken
    @GetMapping("/label/all")
    public Object getAllLabels(){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), labelService.getAllLabels(), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取标签异常");
        }
    }

    /**
     * 根据主键获取label
     * @param id
     * @return
     */
    @JwtToken
    @GetMapping("/label/{id}")
    public Object getLabel(@PathVariable String id){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), labelService.getLabel(id), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取标签异常");
        }
    }

    /**
     * 根据主键删除标签
     * @param id
     * @return
     */
    @JwtToken
    @DeleteMapping("/label/{id}")
    public Object deleteLabel(@PathVariable String id){
        try {
            labelService.deleteLabel(id);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "删除成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "删除标签异常");
        }
    }

    /**
     * 更新标签
     * @param label
     * @return
     */
    @JwtToken
    @PutMapping("/label")
    public Object updateLabel(@RequestBody TXtpzLabel label){
        try {
            labelService.updateLabel(label);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "修改标签异常");
        }
    }

    /**
     * 添加标签
     * @param label
     * @return
     */
    @JwtToken
    @PostMapping("/label")
    public Object addLabel(@RequestBody TXtpzLabel label, HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            String userId = JwtUtil.getUserId(token);
            label.setcCreator(userId);
            labelService.addLabel(label);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "添加标签异常");
        }
    }

    /**
     * 分页获取标签数据
     * @param current
     * @param total
     * @return
     */
    @JwtToken
    @GetMapping("/labels/current/{current}/total/{total}")
    public Object getLabels(@PathVariable int current, @PathVariable int total){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), labelService.getLabels(new Page<>(current, total)), "获取成功");
        } catch (Exception e){
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取标签列表异常");
        }
    }
}
