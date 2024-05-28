package com.justo.util;

import com.justo.dto.request.ProductToPriceDTO;
import com.justo.dto.response.ResponseProductToPriceDTO;
import com.justo.models.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductUtil {

    public static List<ResponseProductToPriceDTO> mapToResponseProductsDTO(List<ProductToPriceDTO> productToPriceListDTO, List<Product> products) {
        return IntStream.range(0, products.size())
                .mapToObj(i -> new ResponseProductToPriceDTO(
                        products.get(i).getId(),
                        productToPriceListDTO.stream().filter(order -> order.getItemId().equals(products.get(i).getId())).findFirst().get().getQuantity(),
                        products.get(i).getDiscount(),
                        products.get(i).getPrices(),
                        BigDecimal.valueOf(0)
                        /*products.get(i).getPrices()
                                .subtract(products.get(i).getPrices()
                                        .multiply(BigDecimal.valueOf(products.get(i).getDiscount()))
                                        .divide(BigDecimal.valueOf(100)))*/
                ))
                .collect(Collectors.toList());
    }

    public static List<ResponseProductToPriceDTO> applyDiscount(List<ResponseProductToPriceDTO> productToPriceListDTO, List<Product> products) {
        return productToPriceListDTO.stream()
                .map(dto -> {
                    Product product = products.stream()
                            .filter(p -> p.getId().equals(dto.getItemId()))
                            .findFirst()
                            .orElse(null);

                    if (product != null && dto.getQuantity() >= product.getFrom()) {
                        BigDecimal discount = product.getPrices().multiply(BigDecimal.valueOf(product.getDiscount())).divide(BigDecimal.valueOf(100));
                        dto.setTotalPrice(product.getPrices().subtract(discount));
                    } else if (product != null) {
                        dto.setTotalPrice(product.getPrices());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
