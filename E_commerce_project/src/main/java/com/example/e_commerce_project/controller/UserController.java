package com.example.e_commerce_project.controller;

import com.example.e_commerce_project.model.ApiResponse;
import com.example.e_commerce_project.model.Buy;
import com.example.e_commerce_project.model.MerchantStock;
import com.example.e_commerce_project.model.User;
import com.example.e_commerce_project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/usr")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view")
    public ResponseEntity getUsers() {
        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !", 201));
    }

    @PutMapping("/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User user
            , @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.updateUsers(index, user);
        return ResponseEntity.status(201).body(new ApiResponse("user updated !", 201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteUser(@PathVariable int index) {
        userService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted !", 200));
    }


    @PostMapping("/addMerchantStock/{id}")
    public ResponseEntity UserAddMerchant(@PathVariable String id, @RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        boolean isValid = userService.UserAddMerchant(merchantStock, id);
        if (isValid) {
            return ResponseEntity.status(201).body(new ApiResponse("New products added to the MerchantStock  !", 201));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Invalid Merchant Stock id", 400));
    }

    @PostMapping("/buyProduct")
    public ResponseEntity BuyProduct(@RequestBody Buy buy, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        int response=userService.BuyProduct(buy);
        switch (response){
            case -1:
                return ResponseEntity.status(400).body(new ApiResponse("user Id not found",400));

            case -2:
                return ResponseEntity.status(400).body(new ApiResponse("product id or merchant id not found",400));

            case -3:
                return ResponseEntity.status(400).body(new ApiResponse("product sold out",400));

            case -4:
                return ResponseEntity.status(400).body(new ApiResponse("user balance<product price",400));

            case 1:
                return ResponseEntity.status(200).body(new ApiResponse("Purchase completed successfully ",200));






        }


        return null;
    }

}
