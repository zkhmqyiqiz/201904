package com.example.springboot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/he",method = RequestMethod.GET)
    public String hello(){
        return "Study Spring boot";
    }
}
