package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class RentRequestRetriever {
    public RentRequest retrieve(){
        Client client = new Client("John", "Wekl");

        LocalDateTime orderedWhen = LocalDateTime.of(2017, 8,1,12,0);

        Product product = new Wine("Rudolf Muller",100);
        Product product1 = new Chocolate("Laderach",200);

        Basket basket = new Basket();
        basket.products.add(product);
        basket.products.add(product1);

        return new RentRequest(client,orderedWhen,basket);
    }
}
