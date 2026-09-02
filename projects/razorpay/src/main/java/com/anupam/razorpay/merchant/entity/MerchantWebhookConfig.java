package com.anupam.razorpay.merchant.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
public class MerchantWebhookConfig { // Webhook is used here to notify the merchant about the payment status and other events related to the payment done via Razorpay.
    // The merchant can configure the webhook URL where they want to receive the notifications.

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(name = "target_url", nullable = false, length = 255)
    private String targetUrl; //www.merchant.com/webhook

    @Column(length = 255)
    private String webhookSecret; // This is used to verify the authenticity of the webhook notification sent by Razorpay.

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(length = 255)
    private Boolean eventTypes; // This is used to specify the event types for which the merchant wants to receive the webhook notifications.
    // For example, payment.captured, payment.failed, etc.
}
