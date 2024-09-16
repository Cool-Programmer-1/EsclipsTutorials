package com.spring.shamshad.com.sp.in.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class School {

    private final Person person;

    @Autowired
    public School(@Qualifier("student") Person person) {
        this.person = person;
    }

    public void showPerson() {
        person.disp();
    }
}
