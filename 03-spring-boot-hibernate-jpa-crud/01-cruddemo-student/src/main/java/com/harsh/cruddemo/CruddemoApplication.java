package com.harsh.cruddemo;

import com.harsh.cruddemo.dao.StudentDAO;
import com.harsh.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			System.out.println("Hello world");

			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Williams","paulWilliams@abc.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Genearted id: " + tempStudent.getId());
		System.out.println("Name: " + tempStudent.getFirstName() + " " + tempStudent.getLastName());
		System.out.println("Email: " + tempStudent.getEmail());
	}
}
/*
@Bean tells Spring to create and manage the CommandLineRunner object. The CommandLineRunner runs automatically after Spring Boot starts and all beans are loaded. The lambda contains the code that will execute. So after the application starts, it prints Hello world.
Flow: Spring Boot starts → Beans loaded → CommandLineRunner executes → "Hello world"
 */