package com.harsh.cruddemo.dao;

import com.harsh.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for Entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
/*
@Repository is a Spring stereotype annotation used to mark a class as a Data Access Layer (DAO) component.
In simple terms: @Repository tells Spring: "This class is responsible for communicating with the database

A transaction is a group of database operations(update) that should be treated as one unit.
@Transactional tells Spring: "Execute this method inside a database transaction." Used when Database is to updatedwoe
*/