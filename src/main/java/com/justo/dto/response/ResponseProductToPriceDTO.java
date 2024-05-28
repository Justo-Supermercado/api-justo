package com.justo.dto.response;

import java.math.BigDecimal;

public class ResponseProductToPriceDTO {

    private Long itemId;
    private int quantity;
    int discountApplied;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public ResponseProductToPriceDTO(Long itemId, int quantity, int discountApplied, BigDecimal price, BigDecimal totalPrice) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.discountApplied = discountApplied;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(int discountApplied) {
        this.discountApplied = discountApplied;
    }
}
