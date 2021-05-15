package com.swisscom.assignment.command;

import com.swisscom.assignment.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpdateStockCommand {

    @Autowired
    private IProductsService productsService;

    public void updateStock(Long productId, int quantity) {
        productsService.updateStock(productId, quantity);
    }
}
