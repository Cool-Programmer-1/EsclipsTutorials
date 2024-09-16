package com.spring.shamshad.com.sp.in.spring;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person {
    @Override
    public void disp() {
        System.out.println("Student is studying java");
    }
}
