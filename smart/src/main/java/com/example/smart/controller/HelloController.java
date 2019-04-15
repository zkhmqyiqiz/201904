package com.example.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解RestController与Controller的区别：
 *  RestController表示该接口默认解析为http请求，不会跳转到jsp/html页面
 *  Controller将会根据配置文件先解析jsp或者html
 *  具体参考https://blog.csdn.net/wuzhangweiss/article/details/81149761*/
@Controller
public class HelloController {
    @RequestMapping("/")
    public String welcome(){
        return "hello";
    }

}
