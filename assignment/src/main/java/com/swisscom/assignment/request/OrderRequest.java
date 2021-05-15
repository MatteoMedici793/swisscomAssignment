package com.swisscom.assignment.request;

import com.swisscom.assignment.model.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderRequest {

    List<ProductDto> products;

}
