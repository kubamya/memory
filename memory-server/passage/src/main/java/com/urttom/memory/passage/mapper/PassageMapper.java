package com.urttom.memory.passage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.urttom.memory.passage.module.TPassage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PassageMapper extends BaseMapper<TPassage> {

    List<Map<String, Object>> getPassageList(Map<String, Object> params);

    List<Map<String, Object>> getThemeList();
}
