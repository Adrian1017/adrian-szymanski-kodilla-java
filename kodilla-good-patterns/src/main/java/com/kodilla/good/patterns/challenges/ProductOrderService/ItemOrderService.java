package com.kodilla.good.patterns.challenges.ProductOrderService;

import java.time.LocalDateTime;

public class ItemOrderService implements OrderService {
    @Override
    public boolean createOrder(User user, Item item, LocalDateTime dateOfOrder) {
        return true;
    }
}
