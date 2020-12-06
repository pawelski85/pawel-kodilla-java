package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository {

    @Override
    public boolean createRental(Client client, LocalDateTime when, Basket basket) {
        System.out.println("Order added to repository");;
        return true;
    }
}
