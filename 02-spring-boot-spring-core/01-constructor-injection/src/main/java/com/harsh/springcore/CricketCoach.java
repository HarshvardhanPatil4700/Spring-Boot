package com.harsh.springcore;

import org.springframework.stereotype.Component;

@Component // It marks the class as Spring Bean (object) and make it available for DI
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice Fast bowling for 15 minutes";
    }
}
