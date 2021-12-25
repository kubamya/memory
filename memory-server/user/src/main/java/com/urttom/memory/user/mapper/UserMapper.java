package com.urttom.memory.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.urttom.memory.user.module.TSysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<TSysUser> {

    /**
     * 查询loginid是否存在
     * @param loginId
     * @return
     */
    TSysUser checkIsRegisted(@Param("loginId") String loginId);
}
