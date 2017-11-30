package com.kodilla.good.patterns.challenges.food2door;


public class ExtraFoodShopOrderProcessor implements OrderProcessor {
    @Override
    public boolean process(OrderRequest orderRequest) {
        if(orderRequest.getPaymentMethod() == PaymentMethod.PAYPAL && orderRequest.getQuantityOfFood() >= 200){
        return true;
        }
        return false;
    }
}
