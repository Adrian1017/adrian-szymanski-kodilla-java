package com.kodilla.good.patterns.challenges.food2door;

public class FoodInformationService implements InformationService {
    @Override
    public void inform(Supplier supplier) {
        System.out.println("Hello " + supplier.getCompanyName() +"! Your product has been ordered");
    }
}
