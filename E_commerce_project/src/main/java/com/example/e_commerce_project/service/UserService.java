package com.example.e_commerce_project.service;
import com.example.e_commerce_project.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private ArrayList<User> usersList=new ArrayList<>();

    private MerchantStockService merchantStockService;
    private ProductService productService;

    public UserService(MerchantStockService merchantStockService,ProductService productService) {
        this.merchantStockService = merchantStockService;
        this.productService=productService;

    }

    public ArrayList<User> getUsers() {
        return usersList;
    }

    public void addUser(User user) {
        usersList.add(user);
    }

    public void updateUsers(int index, User user) {
        usersList.set(index,user);
    }

    public void deleteUser(int index) {
        usersList.remove(index);
    }

    public boolean UserAddMerchant(MerchantStock merchantStock, String id) {
        ArrayList<MerchantStock> merchantStocksList = merchantStockService.getMerchantStock();
        for (int i = 0; i < merchantStocksList.size(); i++) {
            if (merchantStocksList.get(i).getID().equals(id)) {
                merchantStock.setStock(merchantStocksList.get(i).getStock() + merchantStock.getStock());
                merchantStockService.updateMerchantStock(i, merchantStock);
                return true;
            }
        }
        return false;
    }


    public int BuyProduct(Buy buy) {
        ArrayList<MerchantStock> merchantStockList = merchantStockService.getMerchantStock();
        for (int i = 0; i <usersList.size() ; i++) {//checkUserID

            if(usersList.get(i).getID().equals(buy.getUserId())){//will enter if userID found
                for (int j = 0; j < merchantStockList.size(); j++) {

                    if(merchantStockList.get(j).getProductId().equals(buy.getProductId())
                    &&merchantStockList.get(j).getMerchantId().equals(buy.getMerchantId())){
                        ///work
                        if(merchantStockList.get(j).getStock()<=0){
                            return -3;//product sold out
                             }
                        else{
                            if(usersList.get(i).getBalance()
                                    <productService.getPriceByID(merchantStockList.get(j).getProductId())){
                                return -4;//user balance<product price
                            }
                            else{//everything OK
                               //Work
                                merchantStockList.get(j).setStock(merchantStockList.get(j).getStock()-1);
                                usersList.get(i).setBalance(usersList.get(i).getBalance()-
                                        productService.getPriceByID(merchantStockList.get(j).getProductId()));
                                return 1;
                            }
                        }
                    }

                }
                return -2;//product id or merchant id not found
            }
        }//end searching user


        return -1;//user not found
    }
}

