package com.swisscom.assignment.command;

import com.swisscom.assignment.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GetStockInfoCommand {

    @Autowired
    private IProductsService productsService;

    public int getStockInfo(Long productId) {
       return productsService.getStockInfo(productId);
    }
}
