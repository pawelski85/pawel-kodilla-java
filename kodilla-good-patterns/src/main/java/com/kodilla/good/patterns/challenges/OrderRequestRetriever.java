package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){
        Client client = new Client("John", "Wekl");

        LocalDateTime orderedWhen = LocalDateTime.of(2017, 8,1,12,0);

        Product wine = new Wine("Rudolf Muller",100);
        Product chocolate = new Chocolate("Laderach",200);

        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        glutenFreeShop.process(wine);
        List orders=glutenFreeShop.basket.products;

        Basket basket=new Basket();

        basket.orders.put(glutenFreeShop,orders);

        return new OrderRequest(client,orderedWhen,basket);
    }
}
