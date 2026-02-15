package com.pseudowasabi.orderservice.web.dto.internal;

import lombok.Data;

@Data
public class OrdersDetails {
    private String userId;
    private String orderId;

    /* about product */
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
}
