package com.swisscom.assignment.model;

import com.swisscom.assignment.utils.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Long id;
    private ProductType type;
    private String name;
    private String description;
    private int stockNumber;
    private int quantity;

}
