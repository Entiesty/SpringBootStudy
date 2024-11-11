package com.example.springbootstudy.service.impl;

import com.example.springbootstudy.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new RuntimeException("parameter is null!!");
        }
        System.out.println("hello " + name);
    }
}
