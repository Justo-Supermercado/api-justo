package com.justo.mapper;

import com.justo.dto.response.ResponseProductToPriceDTO;
import com.justo.dto.response.ResponseProductsDTO;
import com.justo.models.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Converter<Product, ResponseProductsDTO> {

    @Override
    ResponseProductsDTO convert(Product source);
}
