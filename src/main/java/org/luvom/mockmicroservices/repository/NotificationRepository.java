package org.luvom.mockmicroservices.repository;

import org.luvom.mockmicroservices.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {

    List<Notification> findByUserId(String userId);

    List<Notification> findByUserIdAndReadStatus(String userId, boolean readStatus);

    @Query("SELECT n FROM Notification n WHERE n.sentDate BETWEEN :startDate AND :endDate")
    List<Notification> findNotificationsBetweenDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Modifying
    @Query("UPDATE Notification n SET n.readStatus = true WHERE n.userId = :userId AND n.readStatus = false")
    int markAllAsReadForUser(@Param("userId") String userId);

    long countByUserIdAndReadStatus(String userId, boolean readStatus);

    @Query("SELECT n.notificationType, COUNT(n) FROM Notification n GROUP BY n.notificationType")
    List<Object[]> countByNotificationType();
}
