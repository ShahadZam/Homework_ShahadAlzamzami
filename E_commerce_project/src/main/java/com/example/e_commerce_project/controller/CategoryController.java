package com.example.e_commerce_project.controller;

import com.example.e_commerce_project.model.ApiResponse;
import com.example.e_commerce_project.model.Category;
import com.example.e_commerce_project.model.Product;
import com.example.e_commerce_project.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/view")
    public ResponseEntity getCategory(){
        ArrayList<Category> categories= categoryService.getCategory();
        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.addProduct(category);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.updateCategory(index,category);
        return ResponseEntity.status(201).body( new ApiResponse("Category updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index){
        categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("product deleted !",200));
    }
}
