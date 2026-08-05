package com.harsh.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Eanbles Auto configuration, Component scanning, Additional configuration

// The @SpringBootApplication annotation is a convenient 3-in-1 tool that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan to launch and set up a Spring Boot app.
@SpringBootApplication
public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

}
/* SpringBootApplication class is used to Bootstrap i.e start and prepare application so it is ready to run */