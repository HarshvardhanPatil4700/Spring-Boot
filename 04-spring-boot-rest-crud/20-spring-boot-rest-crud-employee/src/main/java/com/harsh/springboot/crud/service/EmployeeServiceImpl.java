package com.harsh.springboot.crud.service;

import com.harsh.springboot.crud.dao.EmployeeDAO;
import com.harsh.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Service layer is a component that holds the business logic of the application.
 @Service tells Spring this class is a Spring-managed component; it is detected during component scanning and registered as a bean, so other classes can inject and use it.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
