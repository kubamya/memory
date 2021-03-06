package com.urttom.memory.xtpz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzTheme;

import java.util.List;

public interface ThemeService {

    List<TXtpzTheme> getAllThemes();

    IPage<TXtpzTheme> getThemeList(Page<TXtpzTheme> page);

    TXtpzTheme getThemeById(String id);

    void deleteTheme(String id);

    void updateTheme(TXtpzTheme tXtpzTheme);

    void addTheme(TXtpzTheme tXtpzTheme);

    void saveTheme(TXtpzTheme tXtpzTheme, String userId);
}
