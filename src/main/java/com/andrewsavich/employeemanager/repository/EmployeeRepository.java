package com.andrewsavich.employeemanager.repository;

import com.andrewsavich.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    void create (Employee employee);
    void update (Employee employee);
    Employee findById(long id);
    void deleteById(long id);
}
