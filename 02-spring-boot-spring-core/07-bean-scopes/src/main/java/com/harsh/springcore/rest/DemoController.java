package com.harsh.springcore.rest;

import com.harsh.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    // to check if this is the same bean (because the default scope is SINGLETON) but Prototype creates new object for every req
    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach :- " + (myCoach == anotherCoach);
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
/*
getClass() - it returns a Class object, not just the class name. Eg: class com.harsh.springcore.BaseballCoach
getSimpleName() - returns only the class name (without the package name). Eg: DemoController
*/