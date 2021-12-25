package com.urttom.memory.xtpz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzLink;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LinkMapper extends BaseMapper<TXtpzLink> {

    IPage<Map<String, Object>> getLinks(Page<Map<String, Object>> page);

    List<Map<String, Object>> getAllLinks();
}
