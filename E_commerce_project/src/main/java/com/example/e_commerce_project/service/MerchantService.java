package com.example.e_commerce_project.service;

import com.example.e_commerce_project.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    private ArrayList<Merchant> merchantList=new ArrayList<>();

    public ArrayList<Merchant> getMerchant() {
        return merchantList;
    }

    public void addMerchant(Merchant merchant) {
        merchantList.add(merchant);
    }

    public void updateMerchant(int index, Merchant merchant) {
        merchantList.set(index,merchant);
    }

    public void deleteMerchant(int index) {
        merchantList.remove(index);
    }
}
