package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.employee.model.Employee;
import com.example.employee.repository.*;

/*
 * You can use the following import statements
 * 
 */

// Write your code here

@Service
public class EmployeeJpaService implements EmployeeRepository {
    @Autowired
    public EmployeeJpaRepository employeeRepository;
    
    @Override
    public ArrayList<Employee> getEmployees() {
        List<Employee> empList = employeeRepository.findAll();
        ArrayList<Employee> emp = new ArrayList<>(empList);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        try {
            Employee emp = employeeRepository.findById(empId).get();
            return emp;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee addEmployee(Employee emp) {
        employeeRepository.save(emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(int empId, Employee emp) {
        try {
            Employee employee = employeeRepository.findById(empId).get();
            if (emp.getEmployeeName() != null) {
                employee.setEmployeeName(emp.getEmployeeName());
            }
            if (emp.getEmail() != null) {
                employee.setEmail(emp.getEmail());
            }
            if (emp.getDepartment() != null) {
                employee.setDepartment(emp.getDepartment());
            }

            return employeeRepository.save(employee);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteEmployee(int empId) {
        try {
            employeeRepository.deleteById(empId);;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}