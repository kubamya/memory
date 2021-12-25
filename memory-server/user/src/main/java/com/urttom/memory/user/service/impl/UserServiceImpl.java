package com.urttom.memory.user.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.urttom.memory.user.module.TSysUser;
import com.urttom.memory.user.service.UserService;
import com.urttom.memory.user.mapper.UserMapper;
import com.urttom.memory.utils.JwtUtil;
import com.urttom.memory.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(String username, String password) {
        QueryWrapper<TSysUser> tSysUserQueryWrapper = new QueryWrapper<>();
        TSysUser tSysUser = new TSysUser();
        tSysUser.setcLoginId(username);
        tSysUser.setcPassword(MD5Util.encode(password));
        tSysUserQueryWrapper.setEntity(tSysUser);

        Map<String, Object> result = new HashMap<>();

        TSysUser queryResult = userMapper.selectOne(tSysUserQueryWrapper);

        if (queryResult != null) {
            result.put("success", true);
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("userId", queryResult.getcId());
            userInfo.put("userName", queryResult.getcName());
            userInfo.put("loginId", queryResult.getcLoginId());
            userInfo.put("token", JwtUtil.sign(queryResult.getcId()));
            result.put("data", userInfo);

            return result;
        } else {
            result.put("success", false);
            result.put("msg", "用户名或密码错误");
            return result;
        }
    }

    @Override
    public TSysUser checkUserPwd(TSysUser tSysUser) {
        QueryWrapper<TSysUser> tSysUserQueryWrapper = new QueryWrapper<>();
        tSysUserQueryWrapper.setEntity(tSysUser);
        return userMapper.selectOne(tSysUserQueryWrapper);
    }

    @Override
    public Map<String, Object> addUser(TSysUser sysUser) {

        // 检查用户是否已经存在
        TSysUser tSysUser = userMapper.checkIsRegisted(sysUser.getcLoginId());

        if (tSysUser != null) {
            return new HashMap<String, Object>(){{
               put("success", false);
               put("msg", "username already exist");
            }};
        } else {
            sysUser.setcId(IdUtil.simpleUUID());
            sysUser.setcName("MUser" + IdUtil.simpleUUID());
            sysUser.setcPassword(MD5Util.encode(sysUser.getcPassword()));
            userMapper.insert(sysUser);

            return new HashMap<String, Object>(){{
                put("success", true);
                put("msg", "sign up success");
            }};
        }
    }
}
