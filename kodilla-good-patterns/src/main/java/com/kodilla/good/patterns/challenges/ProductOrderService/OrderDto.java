package com.kodilla.good.patterns.challenges.ProductOrderService;

public class OrderDto {
    public User user;
    public boolean isRented;

    public OrderDto(User user, boolean isRented) {
        this.user = user;
        this.isRented = isRented;
    }

    public User getUser() {
        return user;
    }

    public boolean isRented() {
        return isRented;
    }
}
