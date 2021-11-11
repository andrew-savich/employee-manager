package com.andrewsavich.employeemanager.repository;

import com.andrewsavich.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    int create (Employee employee);
    int update (Employee employee);
    List<Employee> findAll();
    Employee findById(long id);
    int deleteById(long id);
}
