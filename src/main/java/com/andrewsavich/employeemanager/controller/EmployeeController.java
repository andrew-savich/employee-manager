package com.andrewsavich.employeemanager.controller;

import com.andrewsavich.employeemanager.model.department.Department;
import com.andrewsavich.employeemanager.model.employee.Employee;
import com.andrewsavich.employeemanager.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getDepartmentsList(){
        List<Employee> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

}
