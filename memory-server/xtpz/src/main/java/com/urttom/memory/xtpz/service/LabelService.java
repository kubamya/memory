package com.urttom.memory.xtpz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzLabel;

public interface LabelService {

    void addLabel(TXtpzLabel label);

    void updateLabel(TXtpzLabel label);

    void deleteLabel(String id);

    TXtpzLabel getLabel(String id);

    IPage<TXtpzLabel> getLabels(Page<TXtpzLabel> page);
}
