package com.kodilla.good.patterns.challenges.productOrderService;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){
        User user = new User("John","Smith");
        Item item = new Item("Computer",300);
        LocalDateTime localDateTime = LocalDateTime.now();

        return new OrderRequest(user,item,localDateTime);
    }
}
