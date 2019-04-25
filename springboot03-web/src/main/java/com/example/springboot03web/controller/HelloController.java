package com.example.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/he")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/sc")
    public String success(){
        return "success";
    }
    @RequestMapping("/newsuccess")
    public String newsuccess(Map<String, Object> map){
        //跳转到返回页面，比如说如下跳转到success.html页面
        map.put("hello","<h2>你好</h2>");
        map.put("users",Arrays.asList("小米","阿里","腾讯"));
        return "success";
    }

    @RequestMapping({"/","/index.html","/index"})
    public String index(){
        return "login";
    }

}
