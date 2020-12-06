package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository {

    @Override
    public boolean createRental(User user, LocalDateTime from, LocalDateTime to) {
        System.out.println("Rental added to repository");;
        return true;
    }
}
