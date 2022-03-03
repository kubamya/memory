package com.urttom.memory.passage.service.impl;

import com.urttom.memory.passage.mapper.PassageLabelMapper;
import com.urttom.memory.passage.module.TPassageLabel;
import com.urttom.memory.passage.service.PassageLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageLabelServiceImpl implements PassageLabelService {

    @Autowired
    private PassageLabelMapper passageLabelMapper;

    @Override
    public void savePassageLabels(String passageId, List<TPassageLabel> tPassageLabels) {
//        passageLabelMapper.;
    }
}
