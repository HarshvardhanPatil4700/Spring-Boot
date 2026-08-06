package com.harsh.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//The CricketCoach is marked as @Primary, hence if we make this also as primary then it gives error
//@Primary
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }
}
