package com.kodilla.good.patterns.challenges.ProductOrderService;

public class OrderProcessor {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private InformationService informationService;

    public OrderProcessor(OrderService orderService, OrderRepository orderRepository, InformationService informationService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.informationService = informationService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered= orderService.createOrder(orderRequest.getUser(), orderRequest.getItem(), orderRequest.getDateOfOrder());
        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(),orderRequest.getItem(), orderRequest.getDateOfOrder());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}