package com.example.schoolmanagementdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    @Id
    @NotNull(message = "Id can't be null")
    private Long id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotNull(message = "salary can't be null")
    private Integer salary;
}
