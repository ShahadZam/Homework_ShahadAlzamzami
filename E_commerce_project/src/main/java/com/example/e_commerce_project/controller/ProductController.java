package com.example.e_commerce_project.controller;

import com.example.e_commerce_project.model.ApiResponse;
import com.example.e_commerce_project.model.Product;
import com.example.e_commerce_project.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/view")
    public ResponseEntity getProducts(){
        ArrayList<Product> products= productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.addProduct(product);
        return ResponseEntity.status(201).body( new ApiResponse("New product added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.updateProduct(index,product);
        return ResponseEntity.status(201).body( new ApiResponse("Product updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        productService.deleteProduct(index);
        return ResponseEntity.status(200).body(new ApiResponse("product deleted !",200));
    }




}
