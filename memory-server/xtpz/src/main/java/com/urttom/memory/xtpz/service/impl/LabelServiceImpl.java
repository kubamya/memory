package com.urttom.memory.xtpz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.service.LabelService;
import com.urttom.memory.xtpz.mapper.LabelMapper;
import com.urttom.memory.xtpz.module.TXtpzLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public void addLabel(TXtpzLabel label) {
        labelMapper.insert(label);
    }

    @Override
    public void updateLabel(TXtpzLabel label) {
        labelMapper.updateById(label);
    }

    @Override
    public void deleteLabel(String id) {
        labelMapper.deleteById(id);
    }

    @Override
    public TXtpzLabel getLabel(String id) {
        return labelMapper.selectById(id);
    }

    @Override
    public IPage<TXtpzLabel> getLabels(Page<TXtpzLabel> page) {
        return labelMapper.getLabels(page);
    }
}
