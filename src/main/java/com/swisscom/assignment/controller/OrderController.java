package com.swisscom.assignment.controller;

import com.swisscom.assignment.command.GetOrderCommand;
import com.swisscom.assignment.command.InsertOrderCommand;
import com.swisscom.assignment.command.UpdateOrderCommand;
import com.swisscom.assignment.mapper.OrderMapper;
import com.swisscom.assignment.model.OrderDto;
import com.swisscom.assignment.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
@Description(value = "management of orders")
public class OrderController {

    @Autowired
    GetOrderCommand getOrderCommand;

    @Autowired
    InsertOrderCommand insertOrderCommand;

    @Autowired
    UpdateOrderCommand updateOrderCommand;

    OrderMapper mapper = OrderMapper.INSTANCE;

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId){
        try{
            OrderDto order = getOrderCommand.getOrder(orderId);
            return ok(order);
        } catch(Exception e){
            return badRequest().build();
        }
    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> insertOrder(@RequestBody OrderRequest request){
        try{
            OrderDto order = mapper.toModel(request);
            Long orderId = insertOrderCommand.insertOrder(order);
            return ok(orderId);
        } catch(Exception e){
            return badRequest().build();
        }
    }

    @PutMapping(value = "/{orderId}/updateOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable Long orderId, @PathParam("orderState") String orderState){
        try{
            OrderDto order = mapper.toModel(orderId, orderState);
            updateOrderCommand.updateOrder(order);
            return ok().build();
        } catch(Exception e){
            return badRequest().build();
        }
    }

}
