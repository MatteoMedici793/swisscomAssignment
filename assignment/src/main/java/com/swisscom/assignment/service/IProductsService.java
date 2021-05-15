package com.swisscom.assignment.service;

import com.swisscom.assignment.model.ProductDto;

import java.util.List;

public interface IProductsService {
    List<ProductDto> getProducts();

    void deleteProduct(Long productId);

    void insertProduct(ProductDto model);

    int getStockInfo(Long productId);

    void updateStock(Long productId, int quantity);
}
