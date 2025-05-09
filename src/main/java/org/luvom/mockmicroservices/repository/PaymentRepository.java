package org.luvom.mockmicroservices.repository;

import org.luvom.mockmicroservices.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    List<Payment> findByOrderId(String orderId);

    List<Payment> findByPaymentStatus(String status);

    @Query("SELECT p FROM Payment p WHERE p.transactionDate BETWEEN :startDate AND :endDate")
    List<Payment> findPaymentsBetweenDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.paymentStatus = 'COMPLETED'")
    BigDecimal getTotalRevenue();

    List<Payment> findByPaymentMethod(String paymentMethod);
}
