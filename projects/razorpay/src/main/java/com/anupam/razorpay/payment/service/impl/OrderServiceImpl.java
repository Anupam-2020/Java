package com.anupam.razorpay.payment.service.impl;

import com.anupam.razorpay.common.enums.OrderStatus;
import com.anupam.razorpay.common.exception.DuplicateResourceException;
import com.anupam.razorpay.payment.dto.request.CreateOrderRequest;
import com.anupam.razorpay.payment.dto.response.OrderResponse;
import com.anupam.razorpay.payment.entity.OrderRecord;
import com.anupam.razorpay.payment.repository.OrderRepository;
import com.anupam.razorpay.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Value("${payment.order.default-expiry-minutes:30}")
    private int defaultExpiryMinutes;

    @Override
    public OrderResponse create(UUID merchantId, CreateOrderRequest request) {
        if(request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())) {
            throw new DuplicateResourceException("ORDER_RECEIPT_DUPLICATE", "Order with receipt already exists: " + request.receipt());
        }

        OrderRecord order = OrderRecord.builder()
                .receipt(request.receipt())
                .amount(request.amount())
                .notes(request.notes())
                .merchantId(merchantId)
                .orderStatus(OrderStatus.CREATED)
                .expiresAt(request.expiresAt() != null ? request.expiresAt() : LocalDateTime.now().plusMinutes(defaultExpiryMinutes))
                .build();

        order = orderRepository.save(order);

        // TODO: send kafka event.

        return new OrderResponse(
                order.getId(),
                order.getMerchantId(),
                order.getReceipt(),
                order.getAmount(),
                order.getOrderStatus(),
                order.getAttempts(),
                order.getNotes(),
                order.getExpiresAt(),
                null
        );
    }
}
