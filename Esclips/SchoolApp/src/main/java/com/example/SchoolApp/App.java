package com.example.SchoolApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Admin admin = context.getBean(Admin.class);
        admin.callFaculty();
        admin.callStudent();
    }
}
