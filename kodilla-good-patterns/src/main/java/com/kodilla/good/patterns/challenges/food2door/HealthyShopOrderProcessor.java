package com.kodilla.good.patterns.challenges.food2door;



public class HealthyShopOrderProcessor implements OrderProcessor {
    @Override
    public boolean process(OrderRequest orderRequest) {
        if(orderRequest.getPaymentMethod() == PaymentMethod.CASH && orderRequest.getQuantityOfFood() <= 50){
            return true;
        }
        return false;
    }
}
