package com.kodilla.good.patterns.challenges.shopProvider;

import java.util.LinkedList;
import java.util.List;

public class OrderRequest {

    private Client client = new Client("Jan", "Kowalski");
    Product wine = new Wine("wino", 1000);
    Product chocolate = new Chocolate("Laderach", 50);
//    private String shopName = "glutenFreeShop";
    ShopProvider shopProvider=new ShopProvider("GlutenFreeShop");

    public Client getClient() {
        return client;
    }

//    public String getShopName() {
//        return shopName;
//    }

    @Override
    public String toString() {
        List<Product> productList=new LinkedList<>();
        productList.add(wine);
        productList.add(chocolate);
        return  ""+productList;
    }
}
