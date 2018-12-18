package com.sequeneRise.es.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.sequeneRise.es.service.ElasticSearchService;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    private TransportClient client;

    @Override
    public void createESIndex(List<JSONObject> list) {
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for(JSONObject jsonObject : list){
            String id = jsonObject.getString("id");
            String indexName = jsonObject.getString("indexName");
            bulkRequestBuilder.add(client.prepareIndex(indexName,"fulltext",id).setSource(jsonObject));
        }
        bulkRequestBuilder.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).execute().actionGet();
    }
}
