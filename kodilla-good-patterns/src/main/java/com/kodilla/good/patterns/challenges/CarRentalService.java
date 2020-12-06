package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService{

    @Override
    public boolean rent(User user, LocalDateTime from, LocalDateTime to) {
        System.out.println("Rented from "+from+" "+"to "+to);
        return true;
    }
}
