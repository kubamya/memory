package com.urttom.memory.user.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.memory.user.module.TSysUser;
import com.urttom.memory.user.service.UserService;
import com.urttom.memory.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {

    Log log = LogFactory.get();

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Object addUser(@RequestBody TSysUser user){
        try {
            userService.addUser(user);
            return RestUtil.comRet(HttpStatus.OK.value(), null, "添加成功");
        } catch (Exception e) {
            log.error("添加用户异常", e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, e.getMessage());
        }
    }
}
