package org.luvom.mockmicroservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.luvom.mockmicroservices.model.Order;
import org.luvom.mockmicroservices.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order Controller", description = "Operations related to orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @Operation(summary = "Get all orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update order")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(id, order));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete order")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get orders by user ID")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }

    @PostMapping("/{id}/cancel")
    @Operation(summary = "Cancel order")
    public ResponseEntity<Order> cancelOrder(@PathVariable String id) {
        return ResponseEntity.ok(orderService.cancelOrder(id));
    }
}
