package com.sequeneRise.light.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ElasticSearchService{

    void createESIndex(List<JSONObject> list);
}

