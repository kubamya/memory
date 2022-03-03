package com.urttom.memory.passage.service;

import com.urttom.memory.passage.module.TPassage;

import java.util.List;
import java.util.Map;

public interface PassageService {

    List<Map<String, Object>> getPassageList(int pageNum, int pageSize);

    List<Map<String, Object>> getThemeList();

    void publishPassage(TPassage passage, String userId);
}
