package com.harsh.cruddemo;

import com.harsh.cruddemo.dao.StudentDAO;
import com.harsh.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean // This will be executed after the Spring beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			System.out.println("Hello world");

			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// studentsByOrder(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id : " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) { // Note: update also happens in Mysql DB
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students with theLastName
		//String a = "Stark";
		//List<Student> theStudents = studentDAO.findByLastName(a);
		List<Student> theStudents = studentDAO.findByLastName("Stark");
		for(Student tempStud : theStudents) {
			System.out.println(tempStud);
		}
	}

	private void studentsByOrder(StudentDAO studentDAO) {
		List<Student> studentsByOrder = studentDAO.findStudentsByOrder();
		for(Student studs : studentsByOrder) {
			System.out.println(studs);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for(Student tempStudents : theStudents) {
			System.out.println(tempStudents);
		}
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

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating new student objects ...");
		Student tempStudent1 = new Student("John","Doe","JohnDoe@abc.com");
		Student tempStudent2 = new Student("Walter","White","WalterWW@abc.com");
		Student tempStudent3 = new Student("Tony","Stark","IronMan@abc.com");

		// save the student objects
		System.out.println("Saving student objects ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a Student object
		System.out.println("Creating a student object ...");
		Student tempStudent = new Student("Joel","Mick","joeMick@abc.com");

		// save a student object
		System.out.println("Saving a student object ...");
		studentDAO.save(tempStudent);

		// display the id of saved student
		// int theId = 150;
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println(myStudent != null ? "Found the student: " + myStudent : "Sorry, Student not found");
	}
}

/*
@Bean tells Spring to create and manage the CommandLineRunner object. The CommandLineRunner runs automatically after Spring Boot starts and all beans are loaded. The lambda contains the code that will execute. So after the application starts, it prints Hello world.
Flow: Spring Boot starts → Beans loaded → CommandLineRunner executes → "Hello world"

working : You create a Student object → DAO passes it to EntityManager → Hibernate converts it into SQL → DataSource provides the DB connection → MySQL stores the student record.
StudentDAO defines what to do, StudentDAOImpl defines how to do it, and Spring manages the objects through Dependency Injection.

Application starts
       ↓
Spring Container creates beans
       ↓
CommandLineRunner runs
       ↓
Create Student Java object
       ↓
StudentDAO → StudentDAOImpl (call is due to @Repository which has component scanning and Translates JDBC exceptions)
       			↓
	EntityManager (JPA)
       ↓
Hibernate
       ↓
DataSource
       ↓
MySQL Database (saves the object)
 */