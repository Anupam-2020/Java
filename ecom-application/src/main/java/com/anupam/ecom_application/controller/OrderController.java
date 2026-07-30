package com.anupam.ecom_application.controller;

import com.anupam.ecom_application.dto.OrderResponseDto;
import com.anupam.ecom_application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestHeader("X-User-Id") String userId) {
        Optional<OrderResponseDto> order = orderService.createOrder(userId);
        return order.map(orderResponseDto -> ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
