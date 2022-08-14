package com.example.e_commerce_project.service;

import com.example.e_commerce_project.model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    private ArrayList<MerchantStock> merchantStocksList=new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocksList;
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocksList.add(merchantStock);
    }

    public void updateMerchantStock(int index, MerchantStock merchantStock) {
        merchantStocksList.set(index,merchantStock);
    }

    public void deleteMerchantStock(int index) {
        merchantStocksList.remove(index);
    }
}
