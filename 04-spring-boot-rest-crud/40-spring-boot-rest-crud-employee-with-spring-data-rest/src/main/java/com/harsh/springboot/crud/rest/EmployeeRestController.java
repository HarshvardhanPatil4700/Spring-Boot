//package com.harsh.springboot.crud.rest;
//
//import com.harsh.springboot.crud.entity.Employee;
//import com.harsh.springboot.crud.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import tools.jackson.databind.json.JsonMapper;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeRestController {
//    /* this is a quick but a dirty practice to add the service in rest controller. Instead, create the service layer and add them there and use it as reference here
//    private EmployeeDAO employeeDAO;
//
//    // quick and dirty : inject employee dao (use constructor injection)
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
//        employeeDAO = theEmployeeDAO;
//    }
//
//    // expose "/employees" and return list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//     */
//
//    private EmployeeService employeeService;
//    private JsonMapper jsonMapper; // In Spring Boot, JsonMapper is a class used to convert Java objects to JSON and JSON back to Java objects. It is part of the Jackson library. It is autoconfigured by Spring boot for JSON processing
//
//    @Autowired
//    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper) {
//        employeeService = theEmployeeService;
//        jsonMapper = theJsonMapper;
//    }
//
//    // expose "/employees" and return list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeService.findAll();
//    }
//
//    // add a mapping for GET /employees/{employeeId}
//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId) {
//        Employee theEmployee = employeeService.findById(employeeId);
//
//        if(theEmployee == null) {
//            throw new RuntimeException("Employee Id Not Found - " + employeeId);
//        }
//        return theEmployee;
//    }
//
//    // add mapping for POST /employees - add new employee
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee theEmployee) {
//        // also just in case if they pass an id in JSON ... set is to 0. this is to force a save of new item ... instead of update
//        theEmployee.setId(0); // in Employee class, if we use private int id; then use setId(0) and if we use private Integer id; then use setId(null);
//
//        Employee dbEmployee = employeeService.save(theEmployee);
//        return dbEmployee;
//    }
//    // @RequestBody Employee theEmployee :- Converts the JSON data sent in the request body into Employee Java object.
//    // theEmployee.setId(0); :- We set the ID to 0 to tell Hibernate that we want to create a new employee rather than update an employee using an ID supplied by the client.
//
//    // add mapping for PUT /employees - update existing employee
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee theEmployee) {
//        Employee dbEmployee = employeeService.save(theEmployee);
//        return dbEmployee;
//    }
//
//    // add mapping for PATCH :- PATCH REST API in Spring Boot updates only the fields provided in the request body while preserving the employee's other fields.
//    @PatchMapping("/employees/{employeeId}")
//    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
//        Employee tempEmployee = employeeService.findById(employeeId);
//
//        // throw exception if id is null:- If no employee exists with the requested ID, the code throws an exception rather than attempting an update.
//        if(tempEmployee == null) {
//            throw new RuntimeException("Employee id not found - " + employeeId);
//        }
//
//        // throw exception if request body contains "id" key
//        if(patchPayload.containsKey("id")) {
//            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
//        }
//
//        //add patchPayload to employee
//        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayload); // Only specified fields changes. The other fields retain their previous values because you update the existing object rather than creating a new, empty employee object.
//        Employee dbEmployee = employeeService.save(patchedEmployee); // Passes the modified employee to the service layer, which saves it through your DAO.
//        return dbEmployee;
//    }
//
//    // add mapping for DELETE /employees/{employeeId} :- deletes the employee
//    @DeleteMapping("/employees/{employeeId}")
//    public String deleteEmployee(@PathVariable int employeeId) {
//        Employee theEmployee = employeeService.findById(employeeId);
//
//        // throw exception if null
//        if(theEmployee == null) {
//            throw new RuntimeException("Employee id not found - " + employeeId);
//        }
//
//        employeeService.deleteById(employeeId);
//        return "Deleted employee id - " + employeeId;
//    }
//}
///*
//1. for the addEmployee :
//In Postman, select POST method -> select Body -> select raw -> select JSON -> write the employee details in JSON format and click Send (you can view the output (changes) below it and in the Database)
//
//2. for the updateEmployee :
//In Postman, select PUT method -> select Body -> select raw -> select JSON -> write the employee details in JSON format and click Send (you can view the output (changes) below it and in the Database)
//
//3. The main difference is that Jackson is the library, while JsonMapper is a class within Jackson (specifically, Jackson 3).
//Think of it this way: Jackson = the entire toolkit, JsonMapper = one tool inside that toolkit.
//
//4. @RequestBody Map<String, Object> patchPayload :- Receives the JSON body as a Java Map.
//Suppose you send this JSON:
//{
//    "email": "newemail@gmail.com"
//}
//The map contains one entry:
//- Key: "email"
//- Value: "newemail@gmail.com"
//Using a map lets the request contain only the fields you want to update.
//
//5. if(patchPayload.containsKey("id")) {
//        throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
//   }
//NOTE : patchPayload is a Map<String, Object> that contains the fields the client wants to change and their new values.
//Explaination : Suppose your database contains this employee:
//{
//    "id": 5,
//    "firstName": "Juan",
//    "lastName": "Vega",
//    "email": "juan@gmail.com"
//}
//You want to change only the email of employee 5.
//Your request URL is: PATCH http://localhost:8080/employees/5
//The 5 in the URL tells your application which employee you want to update.
//What if the client sends this JSON data in Body?
//{
//    "id": 10,
//    "email": "newemail@gmail.com"
//}
//Look carefully! The URL says employee 5, but the JSON body contains "id": 10. This creates a conflict: you're requesting an update to employee 5 while also trying to provide a different ID. Hence, the code(if loop) prevents this.
//
//6. for the updateEmployee :
//In Postman, select DELETE method -> write the http request -> select none -> click Send (you can view the output below it and changes in the Database)
// */