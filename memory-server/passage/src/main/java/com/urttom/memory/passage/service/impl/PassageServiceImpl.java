package com.urttom.memory.passage.service.impl;

import cn.hutool.core.util.IdUtil;
import com.urttom.memory.consts.MemoryCodeConsts;
import com.urttom.memory.passage.mapper.PassageMapper;
import com.urttom.memory.passage.module.TPassage;
import com.urttom.memory.passage.service.PassageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassageServiceImpl implements PassageService {

    @Autowired
    private PassageMapper passageMapper;

    @Override
    public List<Map<String, Object>> getPassageList(int pageNum, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", pageSize);
        params.put("offset", (pageNum - 1) * pageSize);

        List<Map<String, Object>> passageList = passageMapper.getPassageList(params);
        passageList.forEach(passage -> {

        });

        return null;
    }

    @Override
    public List<Map<String, Object>> getThemeList() {
        return passageMapper.getThemeList();
    }

    @Override
    public void publishPassage(TPassage passage, String userId) {

        // 文章存库
        if (StringUtils.isEmpty(passage.getcId())) {
            passage.setcId(IdUtil.simpleUUID());
            passage.setcCreator(userId);
            passage.setcStatus(MemoryCodeConsts.PASSAGE_STATUS_UNAPPROVED);
            passageMapper.insert(passage);
        } else {
            passage.setcUpdater(userId);
            passageMapper.updateById(passage);
        }
    }
}
