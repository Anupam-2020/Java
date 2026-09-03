package com.anupam.razorpay.merchant.services;

import com.anupam.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.anupam.razorpay.merchant.dto.response.ApiKeyCreateResponse;

import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);
}
