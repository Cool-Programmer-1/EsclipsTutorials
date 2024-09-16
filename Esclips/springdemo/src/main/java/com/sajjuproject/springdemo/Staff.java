package com.sajjuproject.springdemo;

import org.springframework.context.annotation.Primary;
@Primary
public class Staff implements Person {
    public void disp() {
        System.out.println("I am Staff");
    }
}
