package com.pseudowasabi.userservice.web.dto.response;

import java.util.Date;

public class OrdersResponse {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;
}
