package com.example.e_commerce_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "ID can't be empty")
    @Size(min = 3,message = "ID must be 3 or more char ")
    private String ID;

    @NotEmpty(message = "product Id can't be empty")
    @Size(min = 3,message = "product Id must be 3 or more char ")
    private String productId;

    @NotEmpty(message = "merchant Id Id can't be empty")
    @Size(min = 3,message = "merchant Id Id must be 3 or more char ")
    private String merchantId;

    @NotNull(message = "stock can't be null")
    @Range(min = 10,message = "stock have to be more than 10 at start")
    private int stock;


}
