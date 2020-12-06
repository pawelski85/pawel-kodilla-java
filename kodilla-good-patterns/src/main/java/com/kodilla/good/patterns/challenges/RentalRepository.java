package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface RentalRepository {
    boolean createRental(Client client, LocalDateTime from, Basket basket);
}
