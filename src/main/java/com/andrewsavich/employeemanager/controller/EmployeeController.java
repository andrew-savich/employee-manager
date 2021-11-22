package com.andrewsavich.employeemanager.controller;

import com.andrewsavich.employeemanager.model.Department;
import com.andrewsavich.employeemanager.model.Employee;
import com.andrewsavich.employeemanager.model.Gender;
import com.andrewsavich.employeemanager.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Returns employee list")
    @ApiResponse(responseCode = "200", description = "Employees were found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeesList(){
        log.info("Controller: getting employee list");

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(summary = "Returns employee gender list")
    @ApiResponse(responseCode = "200", description = "Genders were found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/genders")
    public List<Gender> getGenderList(){
        log.info("Controller: getting gender list");

        return employeeService.getEmployeeGenders();
    }

    @Operation(summary = "Returns employee department list")
    @ApiResponse(responseCode = "200", description = "Departments were found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/departments")
    public List<Department> getDepartmentList(){
        log.info("Controller: getting department list");

        return employeeService.getEmployeeDepartments();
    }

    @Operation(summary = "Returns employee by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the order", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "409", description = "Employee not found", content = @Content)})
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId){
        log.info("Controller: Getting employee with id: " + employeeId);
        Employee employee = employeeService.getEmployeeById(employeeId);
        log.info("Controller: Sending employee: " + employee);

        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "Creates a new employee")
    @ApiResponse(responseCode = "200", description = "Employee was found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping
    public void createEmployee(@RequestBody Employee employee){
        log.info("Controller: Got employee for creating: " + employee);

        employeeService.createEmployee(employee);
    }

    @Operation(summary = "Updates employee")
    @ApiResponse(responseCode = "200", description = "Employee was updated", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        log.info("Controller: Got employee for updating: " + employee);

        employeeService.updateEmployee(employee);
    }

    @Operation(summary = "Deletes employee by id")
    @ApiResponse(responseCode = "200", description = "Employee was deleted", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        log.info("Controller: Deleting employee with id: " + employeeId);

        employeeService.deleteEmployeeById(employeeId);
    }

}
