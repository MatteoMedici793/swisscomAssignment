package com.swisscom.assignment.service;

import com.swisscom.assignment.model.OrderDto;

public interface IOrderService {
    OrderDto getOrder(String orderId);

    Long insertOrder(OrderDto order);

    void updateOrder(OrderDto order);
}
