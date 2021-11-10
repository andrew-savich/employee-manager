package com.andrewsavich.employeemanager.repository.employee;

import com.andrewsavich.employeemanager.model.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    int create (Employee employee);
    int update (Employee employee);
    List<Employee> findAll();
    Employee findById(long id);
    int deleteById(long id);
}
