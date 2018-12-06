package com.vritty.user.controller;

import com.vritty.user.mapper.UserMapper;
import com.vritty.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST,value = "/insert")
    public String insert(@RequestBody User user){
        userMapper.insert(user);
        return "success";
    }
}
