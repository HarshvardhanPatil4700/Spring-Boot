package com.harsh.springcore.config;

import com.harsh.springcore.common.Coach;
import com.harsh.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Configuration class
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() { // the bean id defaults the method name
        return new SwimCoach();
    }
}
