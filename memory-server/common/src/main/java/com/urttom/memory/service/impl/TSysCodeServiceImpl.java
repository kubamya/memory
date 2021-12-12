package com.urttom.memory.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.urttom.memory.mapper.CodeMapper;
import com.urttom.memory.module.TSysCode;
import com.urttom.memory.service.TSysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TSysCodeServiceImpl implements TSysCodeService {

    @Autowired
    private CodeMapper codeMapper;

    @Override
    public List<TSysCode> getAllCodes() {
        return codeMapper.selectList(new QueryWrapper<TSysCode>());
    }
}
