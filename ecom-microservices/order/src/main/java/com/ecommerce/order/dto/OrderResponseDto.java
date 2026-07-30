package com.ecommerce.order.dto;

import com.ecommerce.order.models.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private BigDecimal totalAmount;
    private OrderStatusEnum status;
    private List<OrderItemDto> items;
    private LocalDateTime createdAt;
}
