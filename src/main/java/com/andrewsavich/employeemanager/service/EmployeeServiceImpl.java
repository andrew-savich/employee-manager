package com.andrewsavich.employeemanager.service;

import com.andrewsavich.employeemanager.exception.EmployeeNotFoundException;
import com.andrewsavich.employeemanager.model.Department;
import com.andrewsavich.employeemanager.model.Employee;
import com.andrewsavich.employeemanager.model.Gender;
import com.andrewsavich.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found");
        }

        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Gender> getEmployeeGenders() {
        return Arrays.asList(Gender.values());
    }

    @Override
    public List<Department> getEmployeeDepartments() {
        return Arrays.asList(Department.values());
    }
}
