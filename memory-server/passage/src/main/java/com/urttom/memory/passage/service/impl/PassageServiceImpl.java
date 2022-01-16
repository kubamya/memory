package com.urttom.memory.passage.service.impl;

import cn.hutool.core.util.IdUtil;
import com.urttom.memory.consts.MemoryCodeConsts;
import com.urttom.memory.passage.mapper.PassageMapper;
import com.urttom.memory.passage.module.TPassage;
import com.urttom.memory.passage.service.PassageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageServiceImpl implements PassageService {

    @Autowired
    private PassageMapper passageMapper;

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
