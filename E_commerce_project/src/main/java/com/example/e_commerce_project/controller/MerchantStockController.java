package com.example.e_commerce_project.controller;

import com.example.e_commerce_project.model.ApiResponse;
import com.example.e_commerce_project.model.MerchantStock;
import com.example.e_commerce_project.model.Product;
import com.example.e_commerce_project.service.MerchantStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    public MerchantStockController(MerchantStockService merchantStockService) {
        this.merchantStockService = merchantStockService;
    }

    @GetMapping("/view")
    public ResponseEntity getMerchantStock(){
        ArrayList<MerchantStock> merchantStocks=merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(201).body( new ApiResponse("New Merchant Stock added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantStockService.updateMerchantStock(index,merchantStock);
        return ResponseEntity.status(201).body( new ApiResponse("Merchant Stock updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteMerchantStock(@PathVariable int index){
        merchantStockService.deleteMerchantStock(index);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock deleted !",200));
    }


}
