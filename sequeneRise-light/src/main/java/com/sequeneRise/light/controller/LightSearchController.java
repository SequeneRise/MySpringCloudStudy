package com.sequeneRise.light.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightSearchController {

    @RequestMapping(method = RequestMethod.POST,value = "/light")
    public String light(){
        return "success";
    }
}
