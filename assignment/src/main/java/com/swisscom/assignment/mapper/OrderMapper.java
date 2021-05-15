package com.swisscom.assignment.mapper;

import com.swisscom.assignment.model.OrderDto;
import com.swisscom.assignment.request.OrderRequest;
import com.swisscom.assignment.utils.OrderState;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    OrderDto toModel(OrderRequest request);

    default OrderDto toModel(Long orderId, String orderState){
        OrderDto model = new OrderDto();
        model.setId(orderId);
        model.setState(OrderState.valueOf(orderState));
        return model;
    }
}
