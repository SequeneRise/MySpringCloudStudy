package com.sequeneRise.es.controller;

import com.sequeneRise.es.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private Sender sender;

    @RequestMapping(method = RequestMethod.POST,value = "/send")
    public String insert(){
        sender.sendMessage();
        return "success";
    }
}
