package com.kodilla.good.patterns.challenges.productOrderService;

import java.time.LocalDateTime;

public interface OrderService {
    public boolean createOrder(User user, Item item, LocalDateTime dateOfOrder);
}

