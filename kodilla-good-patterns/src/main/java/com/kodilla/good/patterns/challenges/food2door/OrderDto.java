package com.kodilla.good.patterns.challenges.food2door;

public class OrderDto {
    private Supplier suplier;
    public boolean isRented;

    public OrderDto(Supplier suplier, boolean isRented) {
        this.suplier = suplier;
        this.isRented = isRented;
    }

    public Supplier getSuplier() {
        return suplier;
    }

    public boolean isRented() {
        return isRented;
    }
}
