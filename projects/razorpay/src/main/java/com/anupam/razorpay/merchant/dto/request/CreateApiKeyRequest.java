package com.anupam.razorpay.merchant.dto.request;

import com.anupam.razorpay.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
