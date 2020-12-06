package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        RentRequestRetriever rentalRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentalRequestRetriever.retrieve();


        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new CarRentalService(), new CarRentalRepository());
        rentalProcessor.process(rentRequest);

    }
}
