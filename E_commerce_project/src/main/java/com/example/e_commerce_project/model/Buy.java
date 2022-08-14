package com.example.e_commerce_project.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Buy {
    private String userId;
    private String productId;
    private String merchantId;
}
