package com.harsh.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice batting and sprints";
    }
}
