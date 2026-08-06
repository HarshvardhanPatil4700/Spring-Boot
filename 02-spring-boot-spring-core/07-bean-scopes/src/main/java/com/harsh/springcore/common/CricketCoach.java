package com.harsh.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// Assigning Scope to the bean as :
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // (or) @Scope("prototype")
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Fast bowling";
    }
}
