package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.productOrderService.InformationService;

public class Application {
    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ServiceProcessor serviceProcessor = new ServiceProcessor(new FoodInformationService(), new FoodOrderRepository());
        serviceProcessor.ordering(orderRequest);
    }

}
