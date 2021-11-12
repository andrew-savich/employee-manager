package com.andrewsavich.employeemanager.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("employees")
@Builder
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Department department;
}
