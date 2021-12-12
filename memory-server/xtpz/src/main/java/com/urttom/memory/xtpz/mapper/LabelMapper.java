package com.urttom.memory.xtpz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzLabel;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelMapper extends BaseMapper<TXtpzLabel> {

    IPage<TXtpzLabel> getLabels(Page<TXtpzLabel> page);
}
