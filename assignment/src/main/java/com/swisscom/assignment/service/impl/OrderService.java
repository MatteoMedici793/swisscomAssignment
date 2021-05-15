package com.swisscom.assignment.service.impl;

import com.swisscom.assignment.model.OrderDto;
import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.repository.OrdersRepository;
import com.swisscom.assignment.service.IOrderService;
import com.swisscom.assignment.utils.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrdersRepository repository;

    @Autowired
    ProductsService productsService;

    @Override
    public OrderDto getOrder(String orderId) {
        OrderDto order = new OrderDto();
        return order;
    }

    @Override
    public Long insertOrder(OrderDto order) {
        Long orderId = null;
        boolean outOfStock = checkStockForProduct(order.getProducts());
        if(outOfStock){
            return null;
        }
        for(ProductDto p : order.getProducts()){
           orderId  = repository.insertOrder(OrderState.RUNNING.toString(), p.getId(), p.getQuantity(), new Date());
        }
        return orderId;
    }

    @Override
    public void updateOrder(OrderDto order) {
        if (order.getState().equals(OrderState.CANCELLED)) {
            repository.updateOrder(order.getState().toString(), order.getId(), new Date(), null);
        }
        if(order.getState().equals(OrderState.DELIVERED)){
            repository.updateOrder(order.getState().toString(), order.getId(), null, new Date());
        }
    }

    private boolean checkStockForProduct(List<ProductDto> products) {
        boolean outOfStock = false;
        for(ProductDto p : products){
            int stock = productsService.getStockInfo(p.getId());
            if(stock < p.getQuantity()){
                outOfStock = true;
                return outOfStock;
            }
        }
        return outOfStock;
    }

}
