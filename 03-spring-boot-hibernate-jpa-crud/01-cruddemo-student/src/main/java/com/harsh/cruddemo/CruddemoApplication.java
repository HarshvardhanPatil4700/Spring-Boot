package com.harsh.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean // This will be executed after the Spring beans have been loaded
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello world");
		};
	}
}
/*
@Bean tells Spring to create and manage the CommandLineRunner object. The CommandLineRunner runs automatically after Spring Boot starts and all beans are loaded. The lambda contains the code that will execute. So after the application starts, it prints Hello world.
Flow: Spring Boot starts → Beans loaded → CommandLineRunner executes → "Hello world"
 */