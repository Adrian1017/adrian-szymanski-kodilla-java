package com.kodilla.good.patterns.challenges.productOrderService;

import java.time.LocalDateTime;

public interface OrderRepository {
    public boolean createOrder(User user, Item item, LocalDateTime dateOfOrder);
}
