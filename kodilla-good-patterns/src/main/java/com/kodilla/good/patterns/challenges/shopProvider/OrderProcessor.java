package com.kodilla.good.patterns.challenges.shopProvider;

public class OrderProcessor {

    public void execute(final OrderRequest orderRequest) {
        if (orderRequest.shopProvider.toString().equals("GlutenFreeShop")){
            new GlutenFreeShop().process(orderRequest);
        }
    }
}
