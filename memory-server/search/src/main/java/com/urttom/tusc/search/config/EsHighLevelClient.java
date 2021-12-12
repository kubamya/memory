package com.urttom.tusc.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

@Component
public class EsHighLevelClient {

    public RestHighLevelClient getClient() {
        return new RestHighLevelClient(RestClient.builder(HttpHost.create("http://localhost:9200")));
    }
}
