package com.urttom.memory.user.service;

import com.urttom.memory.user.module.TSysUser;

import java.util.Map;

public interface UserService {

    Map<String, Object> login(String username, String password);

    TSysUser checkUserPwd(TSysUser user);

    void addUser(TSysUser sysUser);
}
