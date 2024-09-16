package com.example.SchoolApp;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person {

    @Override
    public void performDuty() {
        System.out.println("Student is reading Java.");
    }
}
