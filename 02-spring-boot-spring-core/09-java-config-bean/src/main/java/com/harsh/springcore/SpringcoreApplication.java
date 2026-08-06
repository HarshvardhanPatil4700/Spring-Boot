package com.harsh.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}
}
/*
If we run the application without @Qualifier then it gives the error as below below bcoz there are 3 implementations of the Coach interface.Hence, Befor ecalling the DemoController() constructor, Spring has to decide which one to pass as Coach parameter. But the @Qualifier solves the problem by allowing only one the specified class's implementation.

Error : Parameter 0 of constructor in com.harsh.springcore.rest.DemoController required a single bean, but 3 were found:
	- baseballCoach: defined in file [C:\Users\Harsh\Desktop\dev-spring-boot\02-spring-boot-spring-core\04-qualifiers\target\classes\com\harsh\springcore\common\BaseballCoach.class]
	- cricketCoach: defined in file [C:\Users\Harsh\Desktop\dev-spring-boot\02-spring-boot-spring-core\04-qualifiers\target\classes\com\harsh\springcore\common\CricketCoach.class]
	- tennisCoach: defined in file [C:\Users\Harsh\Desktop\dev-spring-boot\02-spring-boot-spring-core\04-qualifiers\target\classes\com\harsh\springcore\common\TennisCoach.class]
*/