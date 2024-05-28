package com.justo.dto.response;

import java.util.List;

public class ResponseProductsListDTO {
    List<ResponseProductsDTO> products;

    public List<ResponseProductsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ResponseProductsDTO> products) {
        this.products = products;
    }
}
