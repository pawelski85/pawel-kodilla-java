package com.kodilla.good.patterns.challenges;

import java.util.Random;

public class RentalProcessor {
    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public RentalProcessor(InformationService informationService, RentalService rentalService, RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest) {
        boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
        if(isRented) {
            informationService.inform(rentRequest.getUser());
            rentalRepository.createRental(rentRequest.getUser(),rentRequest.getFrom(), rentRequest.getTo());
            return new RentalDto(rentRequest.getUser(),true);
        }
        else{
            return new RentalDto(rentRequest.getUser(), false);
        }
    }
}
