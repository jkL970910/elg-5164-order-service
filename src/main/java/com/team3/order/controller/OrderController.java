package com.team3.order.controller;

import java.util.List;
import java.util.Optional;

import com.team3.order.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.team3.order.model.OrderTable;
import com.team3.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderTable> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderTable> getOrderById(@PathVariable("id") Long id) {
        Optional<OrderTable> optionalOrder = orderService.getOrderById(id);

        if (optionalOrder.isPresent()) {
            OrderTable order = optionalOrder.get();
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderTable> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderTable savedOrder = orderService.createOrder(orderRequest.getProductName(),
                orderRequest.getPostUserId(), orderRequest.getPurchaseUserId());
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderTable> deleteOrderById(@PathVariable("id") Long id) {
        Optional<OrderTable> optionalOrder = orderService.deleteOrderById(id);

        if (optionalOrder.isPresent()) {
            OrderTable deletedOrder = optionalOrder.get();
            return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllOrders() {
        orderService.deleteAllOrders();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}