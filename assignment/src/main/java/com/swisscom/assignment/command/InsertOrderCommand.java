package com.swisscom.assignment.command;

import com.swisscom.assignment.model.OrderDto;
import com.swisscom.assignment.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InsertOrderCommand {

    @Autowired
    IOrderService orderService;

    public Long insertOrder(OrderDto order) {
        return orderService.insertOrder(order);
    }
}
