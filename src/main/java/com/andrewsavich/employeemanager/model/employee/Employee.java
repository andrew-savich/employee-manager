package com.andrewsavich.employeemanager.model.employee;

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
    private Long departmentId;

    public Employee(String firstName, String lastName, String jobTitle, Date dateOfBirth, Gender gender, Long departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.departmentId = departmentId;
    }
}
