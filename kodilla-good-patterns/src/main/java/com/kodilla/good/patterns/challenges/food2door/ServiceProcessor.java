package com.kodilla.good.patterns.challenges.food2door;



public class ServiceProcessor {

    private InformationService informationService;
    private OrderRepository orderRepository;

    public ServiceProcessor(InformationService informationService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    public OrderDto ordering(OrderRequest orderRequest){

        boolean isOrdered = orderRequest.getSupplier().getOrderProcessor().process(orderRequest);
        if(isOrdered) {
            informationService.inform(orderRequest.getSupplier());
            orderRepository.createOrder(orderRequest.getSupplier(),orderRequest.getFood(), orderRequest.getQuantityOfFood(), orderRequest.getPaymentMethod());
            return new OrderDto(orderRequest.getSupplier(), true);
        } else {
            return new OrderDto(orderRequest.getSupplier(), false);
        }
    }
}
