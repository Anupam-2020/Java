package com.anupam.razorpay.merchant.services;


import com.anupam.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.anupam.razorpay.merchant.dto.response.MerchantResponse;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);
}
