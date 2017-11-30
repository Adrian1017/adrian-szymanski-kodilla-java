package com.kodilla.good.patterns.challenges.productOrderService;

import java.time.LocalDateTime;

public class ItemOrderRepository implements OrderRepository{

    @Override
    public boolean createOrder(User user, Item item, LocalDateTime dateOfOrder) {
        return true;
    }
}
