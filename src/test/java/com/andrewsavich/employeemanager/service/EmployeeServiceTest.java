package com.andrewsavich.employeemanager.service;

import com.andrewsavich.employeemanager.exception.EmployeeNotFoundException;
import com.andrewsavich.employeemanager.model.Department;
import com.andrewsavich.employeemanager.model.Employee;
import com.andrewsavich.employeemanager.model.Gender;
import com.andrewsavich.employeemanager.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    Employee employee;

    @BeforeEach
    void setUp(){
        employee = new Employee(1L, "Petr", "Petrov", "PM", LocalDate.of(1999, 1, 1), Gender.MALE, Department.MANAGEMENT);
    }

    @Test
    void getAllEmployees(){
        //given
        List<Employee> employees = List.of(employee);
        given(employeeRepository.findAll()).willReturn(employees);
        //when
        Iterable<Employee> receivedEmployees = employeeService.getAllEmployees();
        //then
        then(employeeRepository).should(times(1)).findAll();
        assertIterableEquals(employees, receivedEmployees);
        verifyNoMoreInteractions(employeeRepository);
    }

    @Test
    void findByIdFound() {
        //given
        given(employeeRepository.findById(anyLong())).willReturn(employee);
        //when
        Employee returnedEmployee = employeeService.getEmployeeById(1L);
        //then
        then(employeeRepository).should(times(1)).findById(anyLong());
        assertNotNull(returnedEmployee);
        verifyNoMoreInteractions(employeeRepository);
    }

    @Test
    void findByIdNotFound_shouldThrowsEmployeeNotFoundException() {
        when(employeeRepository.findById(anyLong())).thenThrow(new EmployeeNotFoundException("Employee not found"));

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(666L));
    }

    @Test
    void deleteById() {
        //when
        employeeRepository.deleteById(1L);
        //then
        then(employeeRepository).should(times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(employeeRepository);
    }

}
