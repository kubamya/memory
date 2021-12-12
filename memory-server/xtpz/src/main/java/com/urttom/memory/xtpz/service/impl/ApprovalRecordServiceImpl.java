package com.urttom.memory.xtpz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.mapper.ApprovalRecordMapper;
import com.urttom.memory.xtpz.module.TXtpzApprovalRecord;
import com.urttom.memory.xtpz.service.ApprovalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApprovalRecordServiceImpl implements ApprovalRecordService {

    @Autowired
    private ApprovalRecordMapper approvalRecordMapper;

    @Override
    public void addApprovalRecord(TXtpzApprovalRecord approvalRecord) {
        approvalRecordMapper.insert(approvalRecord);
    }

    @Override
    public IPage<TXtpzApprovalRecord> getApprovalRecords(Page<TXtpzApprovalRecord> page) {
        return approvalRecordMapper.getApprovalRecordList(page);
    }
}
