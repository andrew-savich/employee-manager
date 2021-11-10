package com.andrewsavich.employeemanager.service.employee;

import com.andrewsavich.employeemanager.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
