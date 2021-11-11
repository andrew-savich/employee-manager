package com.andrewsavich.employeemanager.repository;

import com.andrewsavich.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJdbc implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employees (first_name, last_name, job_title, date_of_birth, gender, department_id) VALUES(?,?,?,?,?,?,?)",
                new Object[] { employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getGender(), employee.getDepartmentId()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE employees SET first_name=?, last_name=?, job_title=?, date_of_birth=?, gender=?, department_id=? WHERE id=?",
                new Object[] { employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getGender(), employee.getDepartmentId(), employee.getId() });
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * from employees", BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public Employee findById(long id) {
        try {
            Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Employee.class), id);
            return employee;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
    }
}
