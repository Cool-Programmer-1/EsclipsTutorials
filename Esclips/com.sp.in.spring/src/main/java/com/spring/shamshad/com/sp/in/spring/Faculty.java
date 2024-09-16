package com.spring.shamshad.com.sp.in.spring;

import org.springframework.stereotype.Component;

@Component
public class Faculty implements Person {
    @Override
    public void disp() {
        System.out.println("Faculty is Teaching");
    }
}
