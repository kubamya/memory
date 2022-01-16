package com.urttom.memory.passage.service;

import com.urttom.memory.passage.module.TPassage;

public interface PassageService {

    void publishPassage(TPassage passage, String userId);
}
