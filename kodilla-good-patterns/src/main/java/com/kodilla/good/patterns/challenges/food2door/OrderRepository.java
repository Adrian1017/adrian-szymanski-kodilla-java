package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;

public interface OrderRepository {
        public boolean createOrder(Supplier supplier, Food food, double quantityOfFood, PaymentMethod paymentMethod);
}
