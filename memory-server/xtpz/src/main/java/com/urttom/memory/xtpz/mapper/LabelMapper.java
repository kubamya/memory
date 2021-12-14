package com.urttom.memory.xtpz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzLabel;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface LabelMapper extends BaseMapper<TXtpzLabel> {

    IPage<Map<String, Object>> getLabels(Page<Map<String, Object>> page);
}
