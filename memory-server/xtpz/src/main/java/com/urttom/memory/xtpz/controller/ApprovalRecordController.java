package com.urttom.memory.xtpz.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.urttom.memory.xtpz.service.ApprovalRecordService;
import com.urttom.memory.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approvalRecord/api/v1")
public class ApprovalRecordController {

    Log log = LogFactory.get();

    @Autowired
    private ApprovalRecordService approvalRecordService;

    @GetMapping("/approvalRecords/current/{current}/total/{total}")
    public Object getApprovalRecords(@PathVariable int current, @PathVariable int total){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), approvalRecordService.getApprovalRecords(new Page<>(current, total)), "获取成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "获取审批记录异常");
        }
    }
}
