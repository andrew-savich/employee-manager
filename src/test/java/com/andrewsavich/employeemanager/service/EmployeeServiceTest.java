package com.andrewsavich.employeemanager.service;

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
import java.util.Optional;

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
        employee = Employee.builder()
                .id(1L)
                .firstName("Petr")
                .lastName("Petrov")
                .jobTitle("PM")
                .dateOfBirth(LocalDate.of(1999, 1 , 1))
                .gender(Gender.MALE)
                .department(Department.MANAGEMENT)
                .build();
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
    void findByIdNotFound() {
        //given
        given(employeeRepository.findById(anyLong())).willReturn(null);
        //when
        Employee returnedAnswer = employeeService.getEmployeeById(1L);
        //then
        then(employeeRepository).should(times(1)).findById(anyLong());
        assertNull(returnedAnswer);
        verifyNoMoreInteractions(employeeRepository);
    }

}
