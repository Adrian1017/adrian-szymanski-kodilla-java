package com.kodilla.good.patterns.challenges.ProductOrderService;

public class ItemInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Hi " + user.getName() +"! Your product has been ordered");
    }
}
