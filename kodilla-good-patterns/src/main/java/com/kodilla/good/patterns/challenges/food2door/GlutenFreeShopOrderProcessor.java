package com.kodilla.good.patterns.challenges.food2door;



public class GlutenFreeShopOrderProcessor implements OrderProcessor {
    @Override
    public boolean process(OrderRequest orderRequest) {

        if(orderRequest.getPaymentMethod() == PaymentMethod.MAESTRO && orderRequest.getQuantityOfFood() >= 300){
            return true;
        }
        return false;
    }
}
