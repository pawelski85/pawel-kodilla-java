package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService{

    @Override
    public boolean rent(Client client, LocalDateTime when, Basket basket) {
        System.out.println("Ordered "+when);
        return true;
    }
}
