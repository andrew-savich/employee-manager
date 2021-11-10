package com.andrewsavich.employeemanager.service.department;

import com.andrewsavich.employeemanager.model.department.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    void createDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartmentById(Long id);
}
