package com.andrewsavich.employeemanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("employees")
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Date dateOfBirth;
    private Gender gender;
    private Department department;

}
