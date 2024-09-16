package com.sajjuproject.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class School {

    private final Person person;

    @Autowired
    public School(@Qualifier("Faculty") Person person) {
        this.person = person;
    }

    public void showPerson() {
        person.disp();
    }
}
