package com.harsh.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // It marks a bean as the default choice when multiple beans of the same type exist.
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice Fast bowling";
    }
}
