package com.pseudowasabi.orderservice.web.dto.request;

import lombok.Data;

@Data
public class OrdersRequest {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
}
