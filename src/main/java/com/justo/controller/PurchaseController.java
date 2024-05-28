package com.justo.controller;


import com.justo.dto.request.ProductToPriceDTO;
import com.justo.dto.response.ResponseProductToPriceDTO;
import com.justo.dto.response.ResponseProductsListDTO;
import com.justo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    private final ProductService productService;

    @Autowired
    public PurchaseController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<ResponseProductsListDTO> getProduct() {
        ResponseProductsListDTO response = productService.getProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/purchase/prices")
    public ResponseEntity<List<ResponseProductToPriceDTO>> getProductosByIds (@RequestBody List<ProductToPriceDTO> productToPriceListDTO){
        List<ResponseProductToPriceDTO> response  = productService.getProductosByIds(productToPriceListDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
