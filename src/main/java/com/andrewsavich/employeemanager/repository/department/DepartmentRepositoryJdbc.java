package com.andrewsavich.employeemanager.repository.department;

import com.andrewsavich.employeemanager.model.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryJdbc implements DepartmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Department department) {
        return jdbcTemplate.update("INSERT INTO departments (title) VALUES(?)",
                new Object[] { department.getTitle() });
    }

    @Override
    public int update(Department department) {
        return jdbcTemplate.update("UPDATE departments SET title=? WHERE id=?",
                new Object[] { department.getTitle(), department.getId() });
    }

    @Override
    public List<Department> findAll() {
        return jdbcTemplate.query("SELECT * from departments", BeanPropertyRowMapper.newInstance(Department.class));
    }

    @Override
    public Department findById(long id) {
        try {
            Department department = jdbcTemplate.queryForObject("SELECT * FROM departments WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Department.class), id);
            return department;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM dpartments WHERE id=?", id);
    }
}
