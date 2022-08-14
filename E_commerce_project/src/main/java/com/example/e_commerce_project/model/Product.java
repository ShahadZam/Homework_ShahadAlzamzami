package com.example.e_commerce_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class Product {
    @NotEmpty(message = "ID can't be empty")
    @Size(min = 3,message = "ID must be 3 or more char ")
    private String ID;

    @NotEmpty(message = "name can't be empty")
    @Size(min = 3,message = "name must be 3 as minimum char ")
    private String name;

    @NotNull(message = "price can't be null")
    @Positive(message = "price must be a positive number")
    private Double price;

    @NotEmpty(message = "category ID can't be empty")
    @Size(min = 3,message = "category ID must be 3 as minimum char ")
    private String categoryID;


}
