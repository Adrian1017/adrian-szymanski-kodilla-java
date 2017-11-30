package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;

public class FoodOrderRepository  implements OrderRepository{
    @Override
    public boolean createOrder(Supplier supplier, Food food, double quantityOfFood, PaymentMethod paymentMethod ) {
        return true;
    }
}
