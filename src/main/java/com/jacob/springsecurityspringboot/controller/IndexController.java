package com.jacob.springsecurityspringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        System.out.println("index controller");
        return "index";
    }

    @PostMapping("fail")
    @ResponseBody
    public String fail(){
        System.out.println("fail controller");
        return "fail";
    }
}


