package com.andrewsavich.employeemanager.service;

import com.andrewsavich.employeemanager.model.Department;
import com.andrewsavich.employeemanager.model.Employee;
import com.andrewsavich.employeemanager.model.Gender;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    List<Gender> getEmployeeGenders();
    List<Department> getEmployeeDepartments();
}
