package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // specifying the username,password and roles of users
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}

/*
1. Since we have defined the usernames and passwords here, SpringBoot will not use the username and passwords from the application.properties

2. @Configuration : It tells Spring that this class contains configuration for the application. Spring processes this class to register beans and set up application components. Think of it as a place where you define how Spring should configure something.

3. @Bean : It tells Spring to register the object returned by this method in the Spring container. Spring calls the method to obtain the object and manages it as a bean. userDetailsManager() is the method name; you can choose another valid name.
InMemoryUserDetailsManager is a Spring Security class that stores user details in the application's memory and retrieves them when Spring Security needs to authenticate a user.

4. UserDetails john = User.builder()
- UserDetails is an interface that represents the information Spring Security needs about a user.
- User.builder() starts creating a user object using the Builder pattern.
- john is the Java variable that will hold the completed user object.

5. .username("john") : Sets the username to john. The user will enter this username when logging in.
6. .password("{noop}test123") : Sets the password to test123.
What does {noop} mean?
- {noop} tells Spring Security to use the NoOpPasswordEncoder.
- It means the password is stored and checked as plain text rather than being hashed.
- This is useful for learning and demonstrations, but should not be used in production.
In a real application, use a suitable password encoder such as BCrypt.

7. .roles("EMPLOYEE") : Assigns the role EMPLOYEE to John.
An important detail: Spring Security automatically adds the prefix ROLE_ when you use .roles().So the resulting authority is: ROLE_EMPLOYEE
This role can be used to control access to endpoints or other protected resources. For example, you could restrict an endpoint to employees.

8. .build();
Finishes building the user object and returns the UserDetails instance. At this point, john contains the configured username, password and role.
9. Return the user manager : return new InMemoryUserDetailsManager(john);
This creates an InMemoryUserDetailsManager containing John. InMemoryUserDetailsManager stores user details in application memory. Spring Security can use it to look up (check) users during authentication. The user data is not persisted in a database; it generally disappears when the application restarts.

9. for o/p : in postman, enter url: http://localhost:8080/api/employees and in Authorization section select Basic Auth
then enter the username and its passw to view data(o/p)
if username and passw is correct it shows data with success code as: 200 OK, else gives an denial code as: 401 Unautorized
*/