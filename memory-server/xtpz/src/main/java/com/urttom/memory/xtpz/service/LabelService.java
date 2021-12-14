package com.urttom.memory.xtpz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzLabel;

import java.util.List;
import java.util.Map;

public interface LabelService {

    List<Map<String, Object>> getAllLabels();

    void addLabel(TXtpzLabel label);

    void updateLabel(TXtpzLabel label);

    void deleteLabel(String id);

    TXtpzLabel getLabel(String id);

    IPage<Map<String, Object>> getLabels(Page<Map<String, Object>> page);
}
