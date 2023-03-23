/*
 * You can use the following import statements
 * 
 */

 package com.example.employee.repository;

 import com.example.employee.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;
 

// Write your code here

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {}