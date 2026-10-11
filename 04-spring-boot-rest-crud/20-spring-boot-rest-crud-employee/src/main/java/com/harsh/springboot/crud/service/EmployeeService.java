package com.harsh.springboot.crud.service;

import com.harsh.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
