package com.kodilla.good.patterns.challenges.productOrderService;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private Item item;
    private LocalDateTime dateOfOrder;

    public OrderRequest(User user, Item item, LocalDateTime dateOfOrder) {
        this.user = user;
        this.item = item;
        this.dateOfOrder = dateOfOrder;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }
}
