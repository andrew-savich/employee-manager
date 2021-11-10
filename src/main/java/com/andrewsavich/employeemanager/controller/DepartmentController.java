package com.andrewsavich.employeemanager.controller;

import com.andrewsavich.employeemanager.model.department.Department;
import com.andrewsavich.employeemanager.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getDepartmentsList(){
        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);

        return ResponseEntity.ok(department);
    }

    @PostMapping("/create")
    public void createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
    }

    @PutMapping("/update")
    public void updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
    }
}
