package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/*
 * You can use the following import statements
 *
 * 
 * import java.util.*;
 */

// Write your code here

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeJpaService empService;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return empService.getEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") int empId) {
        return empService.getEmployeeById(empId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        return empService.addEmployee(emp);
    }

    @PutMapping("/employees/{empId}")
    public Employee updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee emp) {
        return empService.updateEmployee(empId, emp);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployee(@PathVariable("empId") int empId) {
        empService.deleteEmployee(empId);
    }
}
