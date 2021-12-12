package com.urttom.tusc.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.urttom.tusc.search.config.EsHighLevelClient;
import com.urttom.tusc.search.consts.TstcEsIndices;
import com.urttom.tusc.search.module.TstcPassage;
import com.urttom.tusc.search.service.SearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private EsHighLevelClient esHighLevelClient;

    @Override
    public Map<String, Object> searchPassaageByTitleAndContent(String keyword) throws IOException {
        // 准备查询请求
        SearchRequest searchRequest = new SearchRequest(TstcEsIndices.PASSAGE);

        // 获取查询客户端
        RestHighLevelClient client = esHighLevelClient.getClient();

        // 构建查询方式
        searchRequest.source().query(QueryBuilders.multiMatchQuery(keyword,
                TstcEsIndices.PASSAGE_FIELD_TITLE,
                TstcEsIndices.PASSAGE_FIELD_CONTENT,
                TstcEsIndices.PASSAGE_FIELD_AUTHOR));

        // 发送查询请求
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        // 获取查询返回命中数据
        SearchHits hits = searchResponse.getHits();

        // 查询返回的总数
        long total = hits.getTotalHits().value;
        // 符合条件的passage结果
        List<TstcPassage> passageList = new ArrayList<>();

        SearchHit[] hitList = hits.getHits();
        for (SearchHit hit : hitList) {
            TstcPassage passage = JSON.parseObject(hit.getSourceAsString(), TstcPassage.class);
            passageList.add(passage);
        }

        // 返回数量和结果
        return new HashMap<String, Object>(){{
            put("total", total);
            put("passages", passageList);
        }};
    }
}
