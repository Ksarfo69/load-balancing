package com.kwame.server1.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String sayHello()
    {
        return "Hello World from Server 1";
    }
}
