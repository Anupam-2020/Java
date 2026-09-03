package com.anupam.razorpay.merchant.controller;

import com.anupam.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.anupam.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.anupam.razorpay.merchant.services.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/merchants/{merchantId}/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ResponseEntity<ApiKeyCreateResponse> create(@PathVariable UUID merchantId,
                                                       @Valid @RequestBody CreateApiKeyRequest request) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(apiKeyService.create(merchantId, request));
    }
}
