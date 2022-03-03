package com.urttom.memory.passage.service;

import com.urttom.memory.passage.module.TPassageLabel;

import java.util.List;

public interface PassageLabelService {

    void savePassageLabels(String passageId, List<TPassageLabel> tPassageLabels);
}
