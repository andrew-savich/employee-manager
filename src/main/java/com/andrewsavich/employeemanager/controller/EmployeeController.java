package com.andrewsavich.employeemanager.controller;

import com.andrewsavich.employeemanager.model.Department;
import com.andrewsavich.employeemanager.model.Employee;
import com.andrewsavich.employeemanager.model.Gender;
import com.andrewsavich.employeemanager.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/employee-manager/api/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployeesList(){
        log.info("Controller: Getting employee list");

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/genders")
    public List<Gender> getGenderList(){
        log.info("Controller: getting genders");

        return employeeService.getEmployeeGenders();
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList(){
        log.info("Controller: getting departments");

        return employeeService.getEmployeeDepartments();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        log.info("Controller: Getting employee with id: " + id);
        Employee employee = employeeService.getEmployeeById(id);
        log.info("Controller: Sending employee: " + employee);

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        log.info("Controller: Got employee for creating: " + employee);

        employeeService.createEmployee(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee){
        log.info("Controller: Got employee for updating: " + employee);

        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        log.info("Controller: Deleting employee with id: " + id);

        employeeService.deleteEmployeeById(id);
    }

}
