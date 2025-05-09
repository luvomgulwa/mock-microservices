package org.luvom.mockmicroservices.repository;

import org.luvom.mockmicroservices.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findByUserId(String userId);

    List<Order> findByStatus(String status);

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> findOrdersBetweenDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT o FROM Order o WHERE SIZE(o.items) > :itemCount")
    List<Order> findOrdersWithMoreThanItems(@Param("itemCount") int itemCount);

    @Query("SELECT o.userId, COUNT(o) FROM Order o GROUP BY o.userId ORDER BY COUNT(o) DESC")
    List<Object[]> countOrdersByUser();
}