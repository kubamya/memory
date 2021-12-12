package com.urttom.memory.xtpz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzApprovalRecord;

public interface ApprovalRecordService {

    void addApprovalRecord(TXtpzApprovalRecord approvalRecord);

    IPage<TXtpzApprovalRecord> getApprovalRecords(Page<TXtpzApprovalRecord> page);
}
