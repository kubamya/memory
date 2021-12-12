package com.urttom.memory.xtpz.service.impl;


import com.urttom.memory.xtpz.service.BroadcastService;
import com.urttom.memory.xtpz.mapper.BroadcastMapper;
import com.urttom.memory.xtpz.module.TXtpzBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    private BroadcastMapper broadcastMapper;

    @Override
    public void updateBroadcast(TXtpzBroadcast broadcast) {
        broadcastMapper.updateById(broadcast);
    }

    @Override
    public void addBroadcast(TXtpzBroadcast broadcast) {
        broadcastMapper.insert(broadcast);
    }
}
