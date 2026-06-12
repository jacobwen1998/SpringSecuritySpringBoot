package com.jacob.springsecurityspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}


