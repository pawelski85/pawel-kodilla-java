package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class RentRequest {
    private Client client;
    private LocalDateTime when;
    private Basket basket;

    public RentRequest(Client client, LocalDateTime when, Basket basket) {
        this.client = client;
        this.when = when;
        this.basket = basket;
    }

    public Client getUser(){
        return client;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public Basket getBasket() {
        return basket;
    }
}
