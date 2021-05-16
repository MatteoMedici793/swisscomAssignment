package com.swisscom.assignment.service.impl;

import com.swisscom.assignment.entity.Orders;
import com.swisscom.assignment.model.OrderDto;
import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.repository.OrdersRepository;
import com.swisscom.assignment.service.IOrderService;
import com.swisscom.assignment.utils.OrderState;
import com.swisscom.assignment.utils.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrdersRepository repository;

    @Autowired
    ProductsService productsService;

    @Override
    public OrderDto getOrder(Long orderId) {
        OrderDto order = new OrderDto();
        List<Orders> orderEntity = repository.findByOrderId(orderId);
        if(!orderEntity.isEmpty() && orderEntity != null){
            List<ProductDto> products = new ArrayList<>();
            order.setState(OrderState.valueOf(orderEntity.get(0).getState()));
            order.setId(orderEntity.get(0).getOrder_id());
            for(Orders o : orderEntity){
                ProductDto p = new ProductDto();
                p.setId(o.getProduct_id());
                p.setName(o.getProduct_name());
                p.setQuantity(o.getQuantity());
                p.setType(ProductType.valueOf(o.getProduct_type()));
                products.add(p);
            }
            order.setProducts(products);
        }

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
            repository.insertOrder(OrderState.RUNNING.toString(),
                    p.getId(), p.getType().toString(), p.getName(), p.getQuantity(), new Date());
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
            updateProductAvailability(order.getId());
        }
    }

    private void updateProductAvailability(Long id) {
        OrderDto order = getOrder(id);
        for(ProductDto p : order.getProducts()){
            productsService.updateProductAvailability(p.getId(), p.getQuantity());
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
