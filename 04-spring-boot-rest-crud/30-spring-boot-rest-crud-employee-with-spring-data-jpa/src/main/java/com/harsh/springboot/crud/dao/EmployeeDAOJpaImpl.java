//package com.harsh.springboot.crud.dao;
//
//import com.harsh.springboot.crud.entity.Employee;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository // This annotation marks a class as a Data Access Layer(DAO) component, responsible for interacting with the database.
//public class EmployeeDAOJpaImpl implements EmployeeDAO{
//
//    // define field for entityManager
//    private EntityManager entityManager;
//
//    //set up constructor injection
//    @Autowired
//    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
//        entityManager = theEntityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        // create a query
//        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
//
//        // execute query and get result list
//        List<Employee> employees = theQuery.getResultList();
//
//        // return the results
//        return employees;
//    }
//
//    @Override
//    public Employee findById(int theId) {
////        // get employee
////        Employee theEmployee = entityManager.find(Employee.class, theId);
////
////        // return employee
////        return theEmployee;
//
//        return entityManager.find(Employee.class, theId);
//    }
//
//    // NOTE : we dont add the @Transactional annotation in DAO because we handle it in Service layer
//    @Override
//    public Employee save(Employee theEmployee) {
//        // save employee
//        Employee dbEmployee = entityManager.merge(theEmployee); // // merge() inserts a new employee or updates an existing employee, depending on the entity's state and ID.
//
//        // return the dbEmployee
//        return dbEmployee;
//    }
//
//    @Override
//    public void deleteById(int theId) {
//        // find employee by id
//        Employee theEmployee = entityManager.find(Employee.class, theId);
//
//        // remove employee
//        entityManager.remove(theEmployee);
//    }
//}
