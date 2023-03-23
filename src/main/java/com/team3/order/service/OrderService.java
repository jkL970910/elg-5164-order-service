package com.team3.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team3.order.model.OrderTable;
import com.team3.order.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderTable> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderTable> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public OrderTable createOrder(String productName, Long postUserId, Long purchaseUserId) {
        OrderTable order = new OrderTable();
        order.setProductName(productName);
        order.setPostUserId(postUserId);
        order.setPurchaseUserId(purchaseUserId);
        return orderRepository.save(order);
    }

    public Optional<OrderTable> deleteOrderById(Long id) {
        Optional<OrderTable> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            OrderTable orderToDelete = optionalOrder.get();
            orderRepository.deleteById(id);
            return Optional.of(orderToDelete);
        } else {
            return Optional.empty();
        }
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

}