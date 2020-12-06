package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface RentalService {
    boolean rent(Client client, LocalDateTime from, Basket basket);
}
