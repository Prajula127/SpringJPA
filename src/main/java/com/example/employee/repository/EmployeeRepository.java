// Write your code here
package com.example.employee.repository;

import com.example.employee.model.*;
import java.util.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();
    Employee getEmployeeById(int empId);
    Employee addEmployee(Employee emp);
    Employee updateEmployee(int empId, Employee emp);
    void deleteEmployee(int empId);
}