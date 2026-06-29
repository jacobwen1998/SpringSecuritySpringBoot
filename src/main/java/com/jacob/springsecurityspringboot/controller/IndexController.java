package com.jacob.springsecurityspringboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @GetMapping("findAll")
    @ResponseBody
    public String findAll(){
        return "findAll";
    }
    @GetMapping("find")
    @ResponseBody
    public String find(){
        return "find";
    }

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


