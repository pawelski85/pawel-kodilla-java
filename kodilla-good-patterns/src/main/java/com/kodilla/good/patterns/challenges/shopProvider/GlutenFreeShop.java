package com.kodilla.good.patterns.challenges.shopProvider;

public class GlutenFreeShop implements Shop {

    @Override
    public void process(OrderRequest orderRequest) {

        System.out.println("Cześć jestem gluten free shop przyjąłem następujące zamówienie do realizacji: " + orderRequest
                + " dla " + orderRequest.getClient());
    }
}
