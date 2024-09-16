package com.example.SchoolApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin {

    private final Student student;
    private final Faculty faculty;

    @Autowired
    public Admin(Student student, Faculty faculty) {
        this.student = student;
        this.faculty = faculty;
    }

    public void callFaculty() {
        faculty.performDuty();
    }

    public void callStudent() {
        student.performDuty();
    }
}
