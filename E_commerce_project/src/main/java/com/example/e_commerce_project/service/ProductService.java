package com.example.e_commerce_project.service;

import com.example.e_commerce_project.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    private ArrayList<Product> productsList=new ArrayList<>();

    public  void updateProduct(int index, Product product) {
        productsList.set(index,product);
    }

    public  ArrayList<Product> getProducts() {
        return productsList;
    }

    public void addProduct(Product product) {
        productsList.add(product);
    }

    public void deleteProduct(int index) {
        productsList.remove(index);
    }

    public double getPriceByID(String id){
        for (int i = 0; i <productsList.size() ; i++) {
            if (productsList.get(i).getID().equals(id))
                return productsList.get(i).getPrice();
        }
        return -1;
    }

}
