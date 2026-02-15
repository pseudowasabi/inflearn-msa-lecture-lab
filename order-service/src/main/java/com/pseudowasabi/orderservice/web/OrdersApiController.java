package com.pseudowasabi.orderservice.web;

import com.pseudowasabi.orderservice.service.OrdersService;
import com.pseudowasabi.orderservice.web.dto.request.OrdersRequest;
import com.pseudowasabi.orderservice.web.dto.response.OrdersResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersApiController {

    private final OrdersService ordersService;

    @GetMapping("/status")
    public String status(HttpServletRequest httpServletRequest) {
        return String.format("Running catalog-service on port %s", httpServletRequest.getServerPort());
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrdersResponse> createOrder(@PathVariable("userId") String userId,
                                                      @RequestBody OrdersRequest ordersRequest) {
        OrdersResponse ordersResponse = ordersService.createOrder(userId, ordersRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersResponse);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrdersResponse>> getOrdersByUserId(@PathVariable("userId") String userId) {
        List<OrdersResponse> ordersResponses = ordersService.getOrdersByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ordersResponses);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrdersResponse> getSingleOrderByOrderId(@PathVariable("orderId") String orderId) {
        OrdersResponse ordersResponse = ordersService.getSingleOrderByOrderId(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(ordersResponse);
    }
}