package org.luvom.mockmicroservices.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    private String notificationId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime sentDate = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean readStatus = false;

    @Column(nullable = false)
    private String notificationType;
}
