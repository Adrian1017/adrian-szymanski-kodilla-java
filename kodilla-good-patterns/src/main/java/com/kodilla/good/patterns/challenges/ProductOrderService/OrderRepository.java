package com.kodilla.good.patterns.challenges.ProductOrderService;

import java.time.LocalDateTime;

public interface OrderRepository {
    public boolean createOrder(User user, Item item, LocalDateTime dateOfOrder);
}
