package com.andrewsavich.employeemanager.repository;

import com.andrewsavich.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    int create (Employee employee);
    int update (Employee employee);
    Employee findById(long id);
    int deleteById(long id);
}
