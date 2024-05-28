package com.justo.repository;

import com.justo.models.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {

    static List<Product> products = new ArrayList<>();

    static {
        Product product = new Product();
        product.setId(1L);
        product.setName("Coca Cola");
        product.setPrices(BigDecimal.valueOf(200));
        product.setDiscount(10);
        product.setFrom(10);

        products.add(product);

        product = new Product();
        product.setId(2L);
        product.setName("Papas fritas pollo");
        product.setPrices(BigDecimal.valueOf(250.55));
        product.setDiscount(15);
        product.setFrom(5);

        products.add(product);

        product = new Product();
        product.setId(3L);
        product.setName("Papas fritas de Cebolla");
        product.setPrices(BigDecimal.valueOf(235.55));
        product.setDiscount(20);
        product.setFrom(1);

        products.add(product);

    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductosByIds(List<Long> ids){
        return products.stream()
                .filter(product -> ids.contains(product.getId()))
                .collect(Collectors.toList());

    }

}
