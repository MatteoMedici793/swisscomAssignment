package com.swisscom.assignment.command;

import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InserProductCommand {

    @Autowired
    private IProductsService productsService;

    public void insertProduct(ProductDto model) {
        productsService.insertProduct(model);
    }
}
