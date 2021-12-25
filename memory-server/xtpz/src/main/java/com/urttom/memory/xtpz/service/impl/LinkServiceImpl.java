package com.urttom.memory.xtpz.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.consts.Consts;
import com.urttom.memory.xtpz.mapper.LinkMapper;
import com.urttom.memory.xtpz.module.TXtpzLink;
import com.urttom.memory.xtpz.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public TXtpzLink getLinkById(String id) {
        return linkMapper.selectById(id);
    }

    @Override
    public void unableLink(TXtpzLink link) {
        link.setcValid(Consts.NO);
        linkMapper.updateById(link);
    }

    @Override
    public void enableLink(TXtpzLink link) {
        link.setcValid(Consts.YES);
        linkMapper.updateById(link);
    }

    @Override
    public void insertLink(TXtpzLink link) {
        link.setcId(IdUtil.simpleUUID());
        link.setcValid(Consts.YES);
        linkMapper.insert(link);
    }

    @Override
    public void updateLink(TXtpzLink link) {
        linkMapper.updateById(link);
    }

    @Override
    public IPage<Map<String, Object>> getLinks(Page<Map<String, Object>> page) {
        return linkMapper.getLinks(page);
    }

    @Override
    public List<Map<String, Object>> getAllLinks() {
        return linkMapper.getAllLinks();
    }
}
