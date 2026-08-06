package com.harsh.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // tells Spring to create a bean only when it is first needed, instead of creating it during application startup.
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }
}
