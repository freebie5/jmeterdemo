package com.example.jmeterdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.jmeterdemo.bean.User;
import com.example.jmeterdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById")
    @ResponseBody
    public String getUserById(@RequestBody Map<String,Object> param) {
        int id = (int) param.get("id");
        User user = userService.getUserById(id);
        System.out.println(new Date().getTime());
        return JSON.toJSONString(user);
    }

    @RequestMapping("/listUser")
    @ResponseBody
    public String listUser(@RequestBody Map<String,Object> param) {
        Map<String,Object> map = new HashMap<>();
        int page = 1;
        int size = 10;
        if(param.get("page")!=null) {
            page = (int)param.get("page");
        }
        if(param.get("size")!=null) {
            size = (int) param.get("size");
        }
        map.put("page",(page-1)*size);
        map.put("size",size);
        if(param.get("id")!=null) {
            map.put("id", param.get("id"));
        }
        if(param.get("age")!=null) {
            map.put("age", param.get("age"));
        }
        if(param.get("name")!=null) {
            map.put("name", param.get("name"));
        }
        List<User> users = userService.listUser(map);
        System.out.println(new Date().getTime());
        return JSON.toJSONString(users);
    }

}
