package com.project.wusuowei.controller;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 20:41
 **/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("HelloController .... hello : " + name);
        return "Hello , " + name;
    }

}
