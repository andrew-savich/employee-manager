package com.andrewsavich.employeemanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("employees")
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Department department;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String jobTitle, LocalDate dateOfBirth, Gender gender, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.department = department;
    }
}
