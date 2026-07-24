package com.springboot.demo.mynewapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //This tells Spring Boot: "This class will handle web requests."
public class FunRestController {

    // expose "/" that returns "Hello World"

    @GetMapping("/") // This means "When someone visits http://localhost:8080/, run the method below." {Here, sayHello()}
    public String sayHello() {
        return "Hello World!";
    }
}
