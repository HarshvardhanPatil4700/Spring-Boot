//package com.harsh.springboot.crud.service;
//
//import com.harsh.springboot.crud.dao.EmployeeRepository;
//import com.harsh.springboot.crud.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
///*
//Service layer is a component that holds the business logic of the application.
// @Service tells Spring this class is a Spring-managed component; it is detected during component scanning and registered as a bean, so other classes can inject and use it.
// */
//@Service
//public class EmployeeServiceImpl implements EmployeeService{
//
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
//        employeeRepository = theEmployeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(int theId) {
//        Optional<Employee> result = employeeRepository.findById(theId);
//
//        Employee theEmployee = null;
//        if(result.isPresent()) {
//            theEmployee = result.get();
//        }else {
//            // we didn't find the employee of given Id then, throw an exception
//            throw new RuntimeException("Did not find employee id - " + theId);
//        }
//        return theEmployee;
//    }
//
//    // @Transactional :- we can remove it since JpaRepository provides this functionality
//    @Override
//    public Employee save(Employee theEmployee) {
//        return employeeRepository.save(theEmployee);
//    }
//
//    // @Transactional :- we can remove it since JpaRepository provides this functionality
//    @Override
//    public void deleteById(int theId) {
//        employeeRepository.deleteById(theId);
//    }
//}
