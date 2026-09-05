package com.anupam.razorpay.payment.entity;

import com.anupam.razorpay.common.entity.Money;
import com.anupam.razorpay.common.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_record")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // no Foreign key - Cross service boundary
    @Column(name = "merchant-id", nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Column(length = 100)
    private String receipt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus orderStatus = OrderStatus.CREATED;

    @Column(nullable = false)
    @Builder.Default
    private Integer attempts = 0;

    @JdbcTypeCode((SqlTypes.JSON)) // This annotation is used to specify that the field should be stored as a JSONB type in the database.
    @Column(columnDefinition = "jsonb") // This annotation is used to specify the column definition(type) for the field in the database.
    private Map<String, Object> notes;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;
}
