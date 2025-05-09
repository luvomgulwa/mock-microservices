package org.luvom.mockmicroservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.luvom.mockmicroservices.model.Notification;
import org.luvom.mockmicroservices.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@Tag(name = "Notification Controller", description = "Operations related to notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    @Operation(summary = "Get all notifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get notification by ID")
    public ResponseEntity<Notification> getNotificationById(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new notification")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.save(notification));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update notification")
    public ResponseEntity<Notification> updateNotification(@PathVariable String id, @RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.update(id, notification));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete notification")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        notificationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get notifications by user ID")
    public ResponseEntity<List<Notification>> getNotificationsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(notificationService.findByUserId(userId));
    }

    @PostMapping("/{id}/mark-read")
    @Operation(summary = "Mark notification as read")
    public ResponseEntity<Notification> markNotificationAsRead(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.markAsRead(id));
    }
}
