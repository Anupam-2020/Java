package com.anupam.razorpay.payment.service;

import com.anupam.razorpay.payment.dto.request.CreateOrderRequest;
import com.anupam.razorpay.payment.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
