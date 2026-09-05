package com.anupam.razorpay.payment.controller;

import com.anupam.razorpay.payment.dto.request.CreateOrderRequest;
import com.anupam.razorpay.payment.dto.response.OrderResponse;
import com.anupam.razorpay.payment.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    UUID merchantId = UUID.fromString("73f672bc-284f-43d5-96a7-0284aacf1668"); // TODO: replace it with MerchantContext

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid CreateOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(merchantId, request));
    }
}
