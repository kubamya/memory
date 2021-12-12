package com.urttom.tusc.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.urttom.tusc.search.config.EsHighLevelClient;
import com.urttom.tusc.search.consts.TstcEsIndices;
import com.urttom.tusc.search.consts.TstcEsMappingTemplate;
import com.urttom.tusc.search.service.InitService;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private EsHighLevelClient esHighLevelClient;

    /**
     * 初始化passage索引库
     * @throws IOException
     */
    @Override
    public boolean initPassageMapping() throws IOException {
        RestHighLevelClient client = esHighLevelClient.getClient();
        CreateIndexRequest request = new CreateIndexRequest(TstcEsIndices.PASSAGE);

        // 判断一下是否存在
        GetIndexRequest exitRequest = new GetIndexRequest(TstcEsIndices.PASSAGE);
        boolean exists = client.indices().exists(exitRequest, RequestOptions.DEFAULT);

        if (exists) {
            return false;
        }

        request.source(JSON.toJSONString(TstcEsMappingTemplate.PASSAGE_MAPPING_TEMPLATE), XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
        client.close();

        return true;
    }
}
