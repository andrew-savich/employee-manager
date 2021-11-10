package com.andrewsavich.employeemanager.repository.department;

import com.andrewsavich.employeemanager.model.department.Department;

import java.util.List;

public interface DepartmentRepository{
    int save (Department department);
    int update (Department department);
    List<Department> findAll();
    Department findById(long id);
    int deleteById(long id);
}
