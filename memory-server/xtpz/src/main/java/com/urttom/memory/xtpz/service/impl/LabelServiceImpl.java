package com.urttom.memory.xtpz.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.generator.UUIDGenerator;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.service.LabelService;
import com.urttom.memory.xtpz.mapper.LabelMapper;
import com.urttom.memory.xtpz.module.TXtpzLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<Map<String, Object>> getAllLabels() {
        return labelMapper.getAllLabels();
    }

    @Override
    public void addLabel(TXtpzLabel label) {
        label.setcId(IdUtil.simpleUUID());
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
    public IPage<Map<String, Object>> getLabels(Page<Map<String, Object>> page) {
        return labelMapper.getLabels(page);
    }
}
