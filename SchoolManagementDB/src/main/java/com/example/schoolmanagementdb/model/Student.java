package com.example.schoolmanagementdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @NotNull(message = "Id can't be null")
    Float Id;
    @NotEmpty(message = "name can't be empty")
    String name;
    @NotNull(message = "age can't be null")
    Integer age;
    @NotEmpty(message = "major can't be empty")
    @Column(columnDefinition = "varchar(10) check ( major='CS' or major='MATH' or major='Engineer')")
    String major;


}
