package com.urttom.memory.xtpz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.module.TXtpzApprovalRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalRecordMapper extends BaseMapper<TXtpzApprovalRecord> {

    IPage<TXtpzApprovalRecord> getApprovalRecordList(Page<TXtpzApprovalRecord> page);
}
