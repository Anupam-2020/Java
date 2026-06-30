package com.anupam.ecommerce.order_service.dto;

import com.anupam.ecommerce.order_service.entity.OrderItem;
import com.anupam.ecommerce.order_service.entity.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDto {
    private Long id;
    private BigDecimal totalPrice;
    private List<OrderRequestItemDto> items;
}
