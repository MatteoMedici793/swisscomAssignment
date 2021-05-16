package com.swisscom.assignment.mapper;

import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.request.ProductRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-16T22:34:29+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toModel(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        return productDto;
    }
}
