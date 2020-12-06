package com.kodilla.good.patterns.challenges;

public class RentalDto {
    public Client client;
    public boolean isRented;

    public RentalDto(final Client client, final boolean isRented){
        this.client = client;
        this.isRented = isRented;
    }
    public Client getUser(){
        return client;
    }
    public boolean isRented(){ return isRented;
    }
}
