package org.luvom.mockmicroservices.model;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderId;

    @Column(nullable = false)
    private String userId;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> items;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private String status = "CREATED";

    @CreationTimestamp
    private LocalDateTime orderDate;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class OrderItem {
        private String productId;
        private Integer quantity;
        private BigDecimal unitPrice;
    }
}
