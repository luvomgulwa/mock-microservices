package org.luvom.mockmicroservices.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private String paymentId;

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String paymentStatus = "PENDING";

    @CreationTimestamp
    private LocalDateTime transactionDate;

    @Column(nullable = false, length = 3)
    private String currency = "R";

    private String paymentGateway;
    private String transactionReference;
}
