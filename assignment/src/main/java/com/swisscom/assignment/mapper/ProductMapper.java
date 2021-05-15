package com.swisscom.assignment.mapper;

import com.swisscom.assignment.model.ProductDto;
import com.swisscom.assignment.request.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toModel(ProductRequest request);
}
