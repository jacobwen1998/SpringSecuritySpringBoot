package com.jacob.springsecurityspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jacob.springsecurityspringboot.mapper")
public class SpringSecuritySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySpringBootApplication.class, args);
    }

}
