package com.andrewsavich.employeemanager.repository;

import com.andrewsavich.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJdbc implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public Employee findById(long id) {
            return jdbcTemplate.query("SELECT * FROM employees WHERE id=?", BeanPropertyRowMapper.newInstance(Employee.class), id)
                    .stream().findAny().orElse((null));
    }

    @Override
    public void create(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees (first_name, last_name, job_title, date_of_birth, gender, department) VALUES(?,?,?,?,?,?)",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getGender().toString(), employee.getDepartment().toString());
    }

    @Override
    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE employees SET first_name=?, last_name=?, job_title=?, date_of_birth=?, gender=?, department=? WHERE id=?",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getGender().toString(), employee.getDepartment().toString(), employee.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
    }
}
