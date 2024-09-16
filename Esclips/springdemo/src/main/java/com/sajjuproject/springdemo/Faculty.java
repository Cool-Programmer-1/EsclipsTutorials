package com.sajjuproject.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Faculty implements Person {
    @Override
    public void disp() {
        System.out.println("I am Faculty");
    }
}
