package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        Supplier supplier = new Supplier("ExtraFoodShop","1600 Amphitheatre Parkway\n" +
                "Mountain View, CA 94043\n" +
                "United States" ,new ExtraFoodShopOrderProcessor());
        Food food = new Food("Pizza");
        double quantityOfFood = 200;
        PaymentMethod paymentMethod = PaymentMethod.PAYPAL;

        return new OrderRequest(supplier, food, quantityOfFood, paymentMethod);
    }
}
