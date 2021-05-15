package com.swisscom.assignment.command;

import com.swisscom.assignment.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DeleteProductCommand {

    @Autowired
    IProductsService productsService;

    public void deleteProduct(Long productId) {
        productsService.deleteProduct(productId);
    }
}
