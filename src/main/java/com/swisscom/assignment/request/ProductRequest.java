package com.swisscom.assignment.request;

import com.swisscom.assignment.utils.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class ProductRequest implements Serializable {

    @NotNull(message = "Product type can not be empty")
    private ProductType type;

    @NotEmpty(message = "Product name can not be empty")
    private String name;

    @NotEmpty(message = "Product description can not be empty")
    private String description;

}
