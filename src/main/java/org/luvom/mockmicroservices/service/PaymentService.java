package org.luvom.mockmicroservices.service;

import org.luvom.mockmicroservices.exception.ResourceNotFoundException;
import org.luvom.mockmicroservices.model.Payment;
import org.luvom.mockmicroservices.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(String id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
    }

    public Payment save(Payment payment) {
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setTransactionDate(LocalDateTime.now());
        payment.setPaymentStatus("CREATED");
        return paymentRepository.save(payment);
    }

    public Payment update(String id, Payment payment) {
        Payment existingPayment = findById(id);
        existingPayment.setOrderId(payment.getOrderId());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setPaymentStatus(payment.getPaymentStatus());
        existingPayment.setCurrency(payment.getCurrency());
        existingPayment.setPaymentGateway(payment.getPaymentGateway());
        return paymentRepository.save(existingPayment);
    }

    public void delete(String id) {
        Payment payment = findById(id);
        paymentRepository.delete(payment);
    }

    public List<Payment> findByOrderId(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public Payment processPayment(String id) {
        Payment payment = findById(id);
        payment.setPaymentStatus("PROCESSED");
        payment.setTransactionReference("TXN-" + UUID.randomUUID());
        return paymentRepository.save(payment);
    }

    public Payment refundPayment(String id) {
        Payment payment = findById(id);
        payment.setPaymentStatus("REFUNDED");
        return paymentRepository.save(payment);
    }
}
