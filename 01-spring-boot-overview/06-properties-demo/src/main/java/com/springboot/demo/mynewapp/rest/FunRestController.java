package com.springboot.demo.mynewapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //This tells Spring Boot: "This class will handle web requests."
public class FunRestController {

    // Injecting the properties for coach.name and team.name using @Value annotation
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @Value("${guest}")
    private String guestName;
    // expose new endpoint for "teaminfo" to access properties
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

    // expose "/" that returns "Hello World"
    @GetMapping("/") // This means "When someone visits http://localhost:8080/, run the method below." {Here, sayHello()}
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWork() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "intro"
    @GetMapping("/intro")
    public String giveIntro(){
        return "Hey! I am Alex. I am 50 yrs old.";
    }
    @GetMapping("/greetGuest")
    public String greetGuest() {
        return "Hello " + "Mr. " + guestName + ". Have a Nice Day!";
    }
}
