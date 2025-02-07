package com.example.api;

import com.example.model.OrderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final List<OrderResponse> orders = List.of(
            new OrderResponse("1", "Laptop"),
            new OrderResponse("1", "Mouse"),
            new OrderResponse("2", "Keyboard")
    );

    @GetMapping("/{userId}")
    public List<OrderResponse> getOrders(@PathVariable String userId) {
        return orders.stream().filter(o -> o.getUserId().equals(userId)).collect(Collectors.toList());
    }
}