package com.harsh.springboot.crud.dao;

import com.harsh.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Employee is Entity type and Integer is data type of primary key

    // that's it ... no need to write any code (we get the CRUD method's implementation from it and we dont need to specify it due to SPRING DATA JPA)
}
