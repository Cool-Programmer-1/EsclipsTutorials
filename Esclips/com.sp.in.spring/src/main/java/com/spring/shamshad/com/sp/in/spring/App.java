package com.spring.shamshad.com.sp.in.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        School school = context.getBean(School.class);
        school.showPerson();
    }
}
