package org.luvom.mockmicroservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.luvom.mockmicroservices.model.Payment;
import org.luvom.mockmicroservices.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment Controller", description = "Operations related to payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    @Operation(summary = "Get all payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get payment by ID")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new payment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.save(payment));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update payment")
    public ResponseEntity<Payment> updatePayment(@PathVariable String id, @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.update(id, payment));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete payment")
    public ResponseEntity<Void> deletePayment(@PathVariable String id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order/{orderId}")
    @Operation(summary = "Get payments by order ID")
    public ResponseEntity<List<Payment>> getPaymentsByOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(paymentService.findByOrderId(orderId));
    }

    @PostMapping("/{id}/process")
    @Operation(summary = "Process payment")
    public ResponseEntity<Payment> processPayment(@PathVariable String id) {
        return ResponseEntity.ok(paymentService.processPayment(id));
    }
}