package com.ecommerce.order.dto;

import lombok.Data;

@Data
public class CartItemRequestDto {
    private String productId;
    private Integer quantity;
}
