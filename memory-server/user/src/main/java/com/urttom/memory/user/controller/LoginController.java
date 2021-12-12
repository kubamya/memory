package com.urttom.memory.user.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.memory.user.module.TSysUser;
import com.urttom.memory.utils.RestUtil;
import com.urttom.memory.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login/api/v1")
public class LoginController {

    Log log = LogFactory.get();

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Object login (@RequestParam String loginId, @RequestParam String password) {
        try {
            Map<String, Object> loginResult = userService.login(loginId, password);
            if ((boolean)loginResult.get("success")) {
                return RestUtil.comRet(HttpStatus.OK.value(), loginResult.get("data"), "登录成功");
            } else {
                return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "用户名或密码错误");
            }
        } catch (Exception e) {
            log.error("登录异常", e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, e.getMessage());
        }
    }
}
