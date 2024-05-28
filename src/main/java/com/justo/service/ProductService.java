package com.justo.service;

import com.justo.dto.request.ProductToPriceDTO;
import com.justo.dto.response.ResponseProductToPriceDTO;
import com.justo.dto.response.ResponseProductsDTO;
import com.justo.dto.response.ResponseProductsListDTO;
import com.justo.enums.APIError;
import com.justo.exception.JustoException;
import com.justo.models.Product;
import com.justo.repository.ProductRepository;
import com.justo.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private ConversionService conversionService;

    @Autowired
    public ProductService(ProductRepository productRepository, ConversionService conversionService) {
        this.productRepository = productRepository;
        this.conversionService = conversionService;
    }

    public ResponseProductsListDTO getProducts() {
        ResponseProductsListDTO responseProductsListDTO = new ResponseProductsListDTO();
        productRepository.getProducts();
        List<ResponseProductsDTO> list = conversionService.convert(productRepository.getProducts(), List.class);
        responseProductsListDTO.setProducts(list);
        return responseProductsListDTO;
    }

    public List<ResponseProductToPriceDTO> getProductosByIds(List<ProductToPriceDTO> productToPriceListDTO) {

        List<Long> ids = new ArrayList<>();
        for (ProductToPriceDTO productToPriceDTO : productToPriceListDTO) {
            Long itemId = productToPriceDTO.getItemId();
            ids.add(itemId);
        }

        List<Product> result = productRepository.getProductosByIds(ids);

        if (result.isEmpty()) {
            throw new JustoException(APIError.PRODUCT_NOT_FOUND);
        }

        List<ResponseProductToPriceDTO> responseProductsListDTO =  ProductUtil.mapToResponseProductsDTO(productToPriceListDTO, result);
        List<ResponseProductToPriceDTO> responseProductsWhitDiscount =  ProductUtil.applyDiscount(responseProductsListDTO, result);

        if (responseProductsListDTO.isEmpty()) {
            throw new JustoException(APIError.PRODUCT_NOT_FOUND);
        }

        return responseProductsWhitDiscount;
    }

}
