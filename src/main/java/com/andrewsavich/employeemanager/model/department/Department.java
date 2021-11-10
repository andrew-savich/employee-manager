package com.andrewsavich.employeemanager.model.department;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("departments")
public class Department {
    @Id
    private Long id;
    private String title;
}
