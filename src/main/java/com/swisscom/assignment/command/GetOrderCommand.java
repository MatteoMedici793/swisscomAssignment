package com.swisscom.assignment.command;

import com.swisscom.assignment.model.OrderDto;
import com.swisscom.assignment.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GetOrderCommand {

    @Autowired
    IOrderService orderService;

    public OrderDto getOrder(Long orderId){
        return orderService.getOrder(orderId);
    }
}
