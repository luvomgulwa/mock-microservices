package org.luvom.mockmicroservices.service;

import org.luvom.mockmicroservices.exception.ResourceNotFoundException;
import org.luvom.mockmicroservices.model.Order;
import org.luvom.mockmicroservices.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    public Order save(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");
        return orderRepository.save(order);
    }

    public Order update(String id, Order order) {
        Order existingOrder = findById(id);
        existingOrder.setUserId(order.getUserId());
        existingOrder.setItems(order.getItems());
        existingOrder.setTotalAmount(order.getTotalAmount());
        return orderRepository.save(existingOrder);
    }

    public void delete(String id) {
        Order order = findById(id);
        orderRepository.delete(order);
    }

    public List<Order> findByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order cancelOrder(String id) {
        Order order = findById(id);
        order.setStatus("CANCELLED");
        return orderRepository.save(order);
    }

    public Order completeOrder(String id) {
        Order order = findById(id);
        order.setStatus("COMPLETED");
        return orderRepository.save(order);
    }
}
