package com.kwame.server1.controllers;

import com.kwame.server1.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/")
    public String sayHello()
    {
        return helloWorldService.sayHello();
    }
}
