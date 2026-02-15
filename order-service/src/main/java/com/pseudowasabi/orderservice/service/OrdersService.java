package com.pseudowasabi.orderservice.service;

import com.pseudowasabi.orderservice.domain.order.Orders;
import com.pseudowasabi.orderservice.domain.order.OrdersRepository;
import com.pseudowasabi.orderservice.web.dto.request.OrdersRequest;
import com.pseudowasabi.orderservice.web.dto.response.OrdersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersResponse createOrder(String userId, OrdersRequest ordersRequest) {

        Orders orders = Orders.builder()
                .productId(ordersRequest.getProductId())
                .quantity(ordersRequest.getQuantity())
                .unitPrice(ordersRequest.getUnitPrice())
                .userId(userId)
                .orderId(UUID.randomUUID().toString())
                .build();

        ordersRepository.save(orders);
        return new OrdersResponse(orders);
    }

    public OrdersResponse getSingleOrderByOrderId(String orderId) {
        Orders orders = ordersRepository.findByOrderId(orderId);
        return new OrdersResponse(orders);
    }

    public List<OrdersResponse> getOrdersByUserId(String userId) {
        Iterable<Orders> orders = ordersRepository.findAllByUserId(userId);
        List<OrdersResponse> ordersResponses = new ArrayList<>();
        orders.forEach(item -> {
            ordersResponses.add(new OrdersResponse(item));
        });

        return ordersResponses;
    }
}
