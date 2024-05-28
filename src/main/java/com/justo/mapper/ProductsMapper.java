package com.justo.mapper;

import com.justo.dto.request.ProductToPriceDTO;
import com.justo.dto.response.ResponseProductsDTO;
import com.justo.models.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductsMapper extends Converter<List<Product>, List<ResponseProductsDTO>> {

    @Override
    List<ResponseProductsDTO> convert(List<Product> source);
}
