package com.alam.com.alam.shamshad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(college1Config.class);
        
        collegeService st = context.getBean(collegeService.class);
        st.show_details();
    }
}
