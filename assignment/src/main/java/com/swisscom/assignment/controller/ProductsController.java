package com.swisscom.assignment.controller;

import com.swisscom.assignment.command.*;
import com.swisscom.assignment.entity.Product;
import com.swisscom.assignment.mapper.ProductMapper;
import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/assignment", produces = {MediaType.APPLICATION_JSON_VALUE})
@Description(value = "management of products")
public class ProductsController {

    @Autowired
    GetProductsCommand getProductsCommand;

    @Autowired
    DeleteProductCommand deleteProductCommand;

    @Autowired
    InserProductCommand insertProductCommand;

    @Autowired
    GetStockInfoCommand stockInfoCommand;

    @Autowired
    UpdateStockCommand updateStockCommand;

    private ProductMapper mapper = ProductMapper.INSTANCE;

    @GetMapping(value = "/getProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> product = getProductsCommand.getProducts();

        return ok(product);
    }

    @PostMapping(value = "/insertProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertProduct(@RequestBody ProductRequest request){
        try{
            ProductDto model = mapper.toModel(request);
            insertProductCommand.insertProduct(model);
            return ok().build();
        } catch(Exception e){
            return badRequest().build();
        }

    }

    @DeleteMapping(value = "/deleteProduct/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        try{
            deleteProductCommand.deleteProduct(productId);
            return ok().build();
        } catch(Exception e){
            return badRequest().build();
        }

    }

    @GetMapping(value = "/getStockInfo/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getStockInfo(@PathVariable Long productId){
        try{
            int availability = stockInfoCommand.getStockInfo(productId);
            return ok(availability);
        } catch(Exception e){
            return badRequest().build();
        }
    }

    @PutMapping(value = "/updateStock/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStock(@PathVariable Long productId, @PathParam("quantity") int quantity){
        try{
            updateStockCommand.updateStock(productId, quantity);
            return ok(null);
        }catch(Exception e){
            return badRequest().build();
        }
    }
}
