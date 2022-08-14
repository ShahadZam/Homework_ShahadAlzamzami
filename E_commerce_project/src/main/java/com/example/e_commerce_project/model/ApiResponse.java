package com.example.e_commerce_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    private String message;
    private int status;
}
