package com.harsh.springcore.rest;

import com.harsh.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class as a Spring Controller. It handles HTTP requests from the browser or client.
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired // it tells Spring to inject the dependency. Note : If you have only constructor then @Autowired is OPTIONAL
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
