package com.harsh.springboot.crud.dao;

import com.harsh.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
