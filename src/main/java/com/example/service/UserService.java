package com.example.service;

import com.example.model.OrderResponse;
import com.example.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserService {
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse getUserOrders(String userId) {
        String orderServiceUrl = "http://order-service:9090/orders/" + userId;
        OrderResponse[] orders = restTemplate.getForObject(orderServiceUrl, OrderResponse[].class);
        assert orders != null;
        return new UserResponse(userId, Arrays.asList(orders));
    }
}