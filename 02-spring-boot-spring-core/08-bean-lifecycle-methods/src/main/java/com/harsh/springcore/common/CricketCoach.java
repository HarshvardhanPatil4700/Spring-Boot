package com.harsh.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method: The init method is a method that Spring automatically calls after creating the bean and injecting all its dependencies. It is executed when we start/run the application
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Starting the Startup stuff");
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }

    // define our destroy method: The destroy method is a method that Spring calls just before destroying a bean (typically when the application shuts down). It is executed when we stop/shut down the application
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("Cleaning up the stuff");
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Fast bowling";
    }
}
