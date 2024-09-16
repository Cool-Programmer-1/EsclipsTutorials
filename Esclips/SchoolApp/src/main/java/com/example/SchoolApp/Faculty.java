package com.example.SchoolApp;

import org.springframework.stereotype.Component;

@Component
public class Faculty implements Person {

    @Override
    public void performDuty() {
        System.out.println("Faculty is teaching.");
    }
}
