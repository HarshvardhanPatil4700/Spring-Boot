package com.harsh.springcore.rest;

import com.harsh.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
/*
1. Only one class can have @Primary annotation else it gives an error
2. we dont need to write the @Qualifier annotation when class is marked as @Primary
3. when different classes in same package are marked with @Primary and @Qualifier then, @Qualifier has the higher priority
 */