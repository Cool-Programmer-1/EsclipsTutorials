package com.sajjuproject.springdemo;

import org.springframework.context.annotation.Primary;
@Primary
public class Faculty1 implements Person {
    public void disp() {
        System.out.println("I am Faculty");
    }
}
