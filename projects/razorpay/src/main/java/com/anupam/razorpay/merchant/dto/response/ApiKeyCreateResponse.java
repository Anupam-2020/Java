package com.anupam.razorpay.merchant.dto.response;

import com.anupam.razorpay.common.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment
) {
}
