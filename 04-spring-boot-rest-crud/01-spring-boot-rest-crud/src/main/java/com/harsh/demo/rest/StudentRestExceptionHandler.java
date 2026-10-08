package com.harsh.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    // add exception handling code of StudentNotFound exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler : to catch and handle any type of exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
/*
@ControllerAdvice :- it tells spring that this class will handle all the exceptions i.e The exception-handler methods inside this class can handle exceptions thrown by controllers

Note : If the same @ExceptionHandler is present both inside the controller and inside a @ControllerAdvice class, Spring can have two possible handlers for the same exception as :
Inside StudentRestController:
@ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<?> handleException(StudentNotFoundException exc) {
    // Controller-specific handling
}

Inside @ControllerAdvice:
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handleException(StudentNotFoundException exc) {
        // Global handling
    }
}

If StudentRestController throws:
throw new StudentNotFoundException("Student not found");
Which one gets used?

The handler inside the controller gets priority. Spring first looks for an exception handler within the controller where the exception occurred. If it doesn't find a suitable handler there, it then looks at applicable @ControllerAdvice handlers.

Work flow :-
Exception occurs in StudentRestController
                ↓
Does StudentRestController have @ExceptionHandler for it?
                   ↓
                YES → use it
                   ↓
                NO
                   ↓
            Check @ControllerAdvice
                   ↓
            Use global handler
 */