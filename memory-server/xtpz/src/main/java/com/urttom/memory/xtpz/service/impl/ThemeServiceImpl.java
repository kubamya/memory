package com.urttom.memory.xtpz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.service.ThemeService;
import com.urttom.memory.xtpz.mapper.ThemeMapper;
import com.urttom.memory.xtpz.module.TXtpzTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public IPage<TXtpzTheme> getThemeList(Page<TXtpzTheme> page) {
        return themeMapper.getThemeList(page);
    }

    @Override
    public TXtpzTheme getThemeById(String id) {
        return themeMapper.selectById(id);
    }

    @Override
    public void deleteTheme(String id) {
        themeMapper.deleteById(id);
    }

    @Override
    public void updateTheme(TXtpzTheme tXtpzTheme) {
        themeMapper.updateById(tXtpzTheme);
    }

    @Override
    public void addTheme(TXtpzTheme tXtpzTheme) {
        themeMapper.insert(tXtpzTheme);
    }
}
