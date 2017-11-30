package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.productOrderService.OrderRequest;

public class Supplier  {
    private String companyName;
    private String companyAdress;
    private OrderProcessor orderProcessor;

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }


    public OrderProcessor getOrderProcessor() {
        return orderProcessor;
    }

    public Supplier(String companyName, String companyAdress, OrderProcessor orderProcessor) {

        this.companyName = companyName;
        this.companyAdress = companyAdress;
        this.orderProcessor = orderProcessor;
    }
}
