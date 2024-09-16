package com.spring.shamshad.com.sp.in.spring;

import org.springframework.stereotype.Component;

@Component
public class Staff implements Person {
    @Override
    public void disp() {
        System.out.println("I am Staff");
    }
}
