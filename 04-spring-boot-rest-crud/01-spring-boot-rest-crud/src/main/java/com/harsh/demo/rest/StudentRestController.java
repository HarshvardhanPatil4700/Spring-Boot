package com.harsh.demo.rest;

import com.harsh.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data .... only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Mario","Rossie"));
        theStudents.add(new Student("Mary","Smith"));
    }

    // define endpoint for "/students" which returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
        //the Jackson Data binding Converts the List<Student> to JSON array (JSON format) behind the scene automatically
    }

    // define the endpoint for "/students/{studentId}" which retrieves a single student by their id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check the studentId against list size
        if((studentId < 0) || (studentId >= theStudents.size())) {
            throw new StudentNotFoundException("Student id NOT FOUND - " + studentId);
        }

        return theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler
//    @ExceptionHandler // tells the Spring that this method is exception handler. The <StudentErrorResponse> denotes the type of response body. The StudentNotFoundException is the exception type that need to be handled. ResponseEntity<StudentErrorResponse> :- This method will return an HTTP response whose body is a StudentErrorResponse object.
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//        // create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value()); // it sets the status field inside your JSON response.
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // it sets the actual HTTP status code of the response.
//    }
//
//    // add another exception handler : to catch and handle any exception (catch all)
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//        // create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}


/*
In this example, when the client sends a GET request to /api/students, the getStudents() method creates and returns a List<Student> containing three Student objects. Spring Boot uses Jackson Data Binding to automatically convert this Java List<Student> into a JSON array and sends it as the HTTP response. So, the conversion happening here is Java List<Student> → Jackson → JSON array.

error.setStatus(HttpStatus.NOT_FOUND.value()); :- Sets the status field inside your JSON response.
and
return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); :- Sets the actual HTTP status code of the response.

 */