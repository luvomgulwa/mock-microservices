package org.luvom.mockmicroservices.service;

import org.luvom.mockmicroservices.exception.ResourceNotFoundException;
import org.luvom.mockmicroservices.model.Notification;
import org.luvom.mockmicroservices.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public Notification findById(String id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
    }

    public Notification save(Notification notification) {
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setSentDate(LocalDateTime.now());
        notification.setReadStatus(false);
        return notificationRepository.save(notification);
    }

    public Notification update(String id, Notification notification) {
        Notification existingNotification = findById(id);
        existingNotification.setUserId(notification.getUserId());
        existingNotification.setMessage(notification.getMessage());
        existingNotification.setNotificationType(notification.getNotificationType());
        return notificationRepository.save(existingNotification);
    }

    public void delete(String id) {
        Notification notification = findById(id);
        notificationRepository.delete(notification);
    }

    public List<Notification> findByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Notification markAsRead(String id) {
        Notification notification = findById(id);
        notification.setReadStatus(true);
        return notificationRepository.save(notification);
    }

    public List<Notification> findUnreadByUser(String userId) {
        return notificationRepository.findByUserIdAndReadStatus(userId, false);
    }
}