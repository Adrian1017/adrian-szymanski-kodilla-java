package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;

public class OrderRequest {
    private Supplier supplier;
    private Food food;
    private double quantityOfFood;
    private PaymentMethod paymentMethod;

    public Supplier getSupplier() { return supplier; }

    public Food getFood() {
        return food;
    }

    public double getQuantityOfFood() {
        return quantityOfFood;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public OrderRequest(Supplier supplier, Food food, double quantityOfFood, PaymentMethod paymentMethod) {

        this.supplier = supplier;
        this.food = food;
        this.quantityOfFood = quantityOfFood;
        this.paymentMethod = paymentMethod;
    }
}
