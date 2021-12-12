package com.urttom.tusc.search.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.tusc.search.service.SearchService;
import com.urttom.tusc.search.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/api/v1")
public class SearchController {

    Log log = LogFactory.get();

    @Autowired
    private SearchService searchService;

    /**
     * 查询文章，查询范围为标题和正文
     * @param keyword
     * @return
     */
    @GetMapping("/titleAndContent/{keyword}")
    public Object searchPassaageByTitleAndContent(@PathVariable String keyword){
        try {
            return RestUtil.comRet(HttpStatus.OK.value(), searchService.searchPassaageByTitleAndContent(keyword), "查询成功");
        } catch (Exception e) {
            log.error(e);
            return RestUtil.comRet(HttpStatus.INTERNAL_SERVER_ERROR.value(), e, "查询文章异常");
        }
    }
}
