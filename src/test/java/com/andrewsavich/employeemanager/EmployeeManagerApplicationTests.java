package com.andrewsavich.employeemanager;

import com.andrewsavich.employeemanager.controller.EmployeeController;
import com.andrewsavich.employeemanager.repository.EmployeeRepository;
import com.andrewsavich.employeemanager.service.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagerApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() {
		Assertions.assertThat(employeeRepository).isNotNull();
		Assertions.assertThat(employeeService).isNotNull();
		Assertions.assertThat(employeeController).isNotNull();
	}

}
