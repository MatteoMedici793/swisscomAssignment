package com.swisscom.assignment.service.impl;

import com.swisscom.assignment.entity.Product;
import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.repository.ProductsRepository;
import com.swisscom.assignment.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        return products;
    }

    @Override
    public void deleteProduct(Long productId) {
        productsRepository.deleteById(productId);
    }

    @Override
    public void insertProduct(ProductDto model) {
        productsRepository.insertProduct(model.getType().toString(), model.getName(), model.getDescription());
    }

    @Override
    public int getStockInfo(Long productId) {
        Optional<Product> product = productsRepository.findById(productId);
        return product.get().getAvailability();
    }

    @Override
    public void updateStock(Long productId, int quantity) {
        int availability = getStockInfo(productId);
        quantity += availability;
        productsRepository.updateStock(quantity, productId);
    }
}
