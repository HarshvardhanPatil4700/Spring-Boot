package com.harsh.demo.rest;

import com.harsh.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // define endpoint for "/students" which returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Mario","Rossie"));
        theStudents.add(new Student("Mary","Smith"));

        return theStudents;
        //the Jackson Data binding Converts the List<Student> to JSON array (JSON format) behind the scene automatically
    }
}
/*
In this example, when the client sends a GET request to /api/students, the getStudents() method creates and returns a List<Student> containing three Student objects. Spring Boot uses Jackson Data Binding to automatically convert this Java List<Student> into a JSON array and sends it as the HTTP response. So, the conversion happening here is Java List<Student> → Jackson → JSON array.
 */