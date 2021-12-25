package com.urttom.memory.xtpz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzLink;

import java.util.List;
import java.util.Map;

public interface LinkService {

    TXtpzLink getLinkById(String id);

    void unableLink(TXtpzLink link);

    void enableLink(TXtpzLink link);

    void insertLink(TXtpzLink link);

    void updateLink(TXtpzLink link);

    IPage<Map<String, Object>> getLinks(Page<Map<String, Object>> page);

    List<Map<String, Object>> getAllLinks();
}
