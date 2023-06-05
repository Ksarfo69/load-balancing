package com.kwame.loadbalancer.controllers;

import com.kwame.loadbalancer.services.LoadBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancerController {
    @Autowired
    private LoadBalancerService loadBalancerService;

    @GetMapping("/")
    public String sayHello()
    {
        return loadBalancerService.sayHello();
    }
}
