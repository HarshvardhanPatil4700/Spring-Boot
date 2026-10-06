package com.harsh.cruddemo.dao;

import com.harsh.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for Entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE / SAVE :- implement the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    // READ / RETRIEVE :- Here, we don't use @Transactional as we are doing a query (read) and updating or changing data in DB table
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query using entityManager.createQuery()
        // Here, the "FROM Student" give me all the objects/entities from Student entity. The 'Student.class' tells JPA that the result of this query should be converted into Student objects
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return the query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentsByOrder() {
        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class); // it sorts the lastName ascending (by default), else mention desc for descending ordering as :
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class); // theData is JPQL Named parameter(they are prefixed with a colon) that is declared below :

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional // since, we are performing an update(change) in database
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student using id: primary key
        Student theStudent = entityManager.find(Student.class, id);

        // delete the retrieved student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
/*
@Repository is a Spring stereotype annotation used to mark a class as a Data Access Layer (DAO) component.
In simple terms: @Repository tells Spring: "This class is responsible for communicating with the database

A transaction is a group of database operations(update) that should be treated as one unit.
@Transactional tells Spring: "Execute this method inside a database transaction." Used when Database is to updatedwoe
*/