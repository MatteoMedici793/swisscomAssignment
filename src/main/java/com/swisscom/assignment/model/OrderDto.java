package com.swisscom.assignment.model;

import com.swisscom.assignment.utils.OrderState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderDto implements Serializable {

    private Long id;
    private List<ProductDto> products;
    private OrderState state;

}
