package com.sequeneRise.light.controller;

import com.alibaba.fastjson.JSONObject;
import com.sequeneRise.light.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    /**
     * ES导入数据
     * @return success
     */
    @RequestMapping(method = RequestMethod.POST,value = "/import")
    public String importDataToES(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("indexName","world");
        jsonObject.put("id",1);
        jsonObject.put("name","cc");
        jsonObject.put("age",18);
        jsonObject.put("height",180);
        List<JSONObject> list = new ArrayList<>();
        list.add(jsonObject);
        elasticSearchService.createESIndex(list);
        return "success";
    }
}
