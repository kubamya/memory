package com.urttom.tusc.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.urttom.tusc.search.config.EsHighLevelClient;
import com.urttom.tusc.search.consts.TstcEsIndices;
import com.urttom.tusc.search.module.TstcPassage;
import com.urttom.tusc.search.service.DocumentService;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private EsHighLevelClient esHighLevelClient;

    @Override
    public void deletePassageFromEs(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(TstcEsIndices.PASSAGE, id);
        RestHighLevelClient client = esHighLevelClient.getClient();
        client.delete(request, RequestOptions.DEFAULT);
        client.close();
    }

    @Override
    public TstcPassage getPassageFromEs(String id) throws IOException {
        GetRequest request = new GetRequest(TstcEsIndices.PASSAGE, id);
        RestHighLevelClient client = esHighLevelClient.getClient();
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        TstcPassage passage = JSON.parseObject(sourceAsString, TstcPassage.class);
        client.close();
        return passage;
    }

    @Override
    public void addPassage(TstcPassage passage) throws IOException {
        IndexRequest request = new IndexRequest(TstcEsIndices.PASSAGE).id(passage.getId());
        request.source(JSON.toJSONString(passage), XContentType.JSON);
        RestHighLevelClient client = esHighLevelClient.getClient();
        client.index(request, RequestOptions.DEFAULT);
        client.close();
    }
}
