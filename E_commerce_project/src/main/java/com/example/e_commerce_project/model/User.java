package com.example.e_commerce_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "ID can't be empty")
    @Size(min = 3,message = "ID must be 3 or more char ")
    private String ID;

    @NotEmpty(message = "userName can't be empty")
    @Size(min = 5,message = "userName must be 5 char as minimum  ")
    private String userName;

    @NotEmpty(message = "userName can't be empty")
    @Size(min = 6,message = "userName must be 6 char as minimum  ")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",message = "please enter strong password")
    private String password;

    @NotEmpty(message = "email can't be empty")
    @Email(message = "It has to be a valid email")
    private String email;


    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "(admin|user)",message = "Role must be in admin or user only")
    private String role;

    @NotNull(message = "balance can't be null")
    @Positive(message = "balance must be a positive number")
    private double balance;

}

//        password ( must not be empty , have to be 6 length long , must have characters and digits ).
//        email ( must not be empty , must be valid email ).
//        role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
//        balance ( must not be empty , have to be positive ).
