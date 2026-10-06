package com.harsh.cruddemo.dao;

import com.harsh.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);// Integer is used instead of int mainly because JPA/Spring Data works with object types, and an ID can sometimes be null

    List<Student> findAll();

    List<Student> findStudentsByOrder();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id); // Integer can hold null whereas int cannot, so use Integer

    int deleteAll();
}
/*
Integer is used over int because :
1. JPA/Spring Data works with object types
2. int id; -> Primitive type, Cannot be null, Default value is 0
 Integer id; -> Wrapper/object type, Can be null, Useful when an ID may be absent/not provided
*/