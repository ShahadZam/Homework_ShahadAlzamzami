package com.example.e_commerce_project.controller;

import com.example.e_commerce_project.model.ApiResponse;
import com.example.e_commerce_project.model.Merchant;
import com.example.e_commerce_project.service.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/view")
    public ResponseEntity getMerchants(){
        ArrayList<Merchant> merchants= merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body( new ApiResponse("New Merchant added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.updateMerchant(index,merchant);
        return ResponseEntity.status(201).body( new ApiResponse("merchant updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){
        merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted !",200));
    }
}
