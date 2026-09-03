package com.anupam.razorpay.merchant.services.impl;

import com.anupam.razorpay.common.exception.ResourceNotFoundException;
import com.anupam.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.anupam.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.anupam.razorpay.merchant.entity.ApiKey;
import com.anupam.razorpay.merchant.entity.Merchant;
import com.anupam.razorpay.merchant.repository.ApiKeyRepository;
import com.anupam.razorpay.merchant.repository.MerchantRepository;
import com.anupam.razorpay.merchant.services.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;

    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("merchant", merchantId));

        String keyId = "rzp" + request.environment().name().toUpperCase()+"big_random_string";
        String rawSecret = "big_random_secret"; // TODO: replace with cryptography.

        ApiKey apiKey = ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret) // TODO: encode with BcryptPasswordEncoder
                .environment(request.environment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);

        return new ApiKeyCreateResponse(apiKey.getId(), keyId, rawSecret, request.environment());
    }
}
