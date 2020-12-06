package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void inform(Client client, Basket basket) {
        System.out.println(client);
        basket.products.forEach(System.out::println);
    }
}
