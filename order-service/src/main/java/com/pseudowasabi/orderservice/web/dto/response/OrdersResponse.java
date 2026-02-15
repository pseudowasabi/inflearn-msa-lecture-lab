package com.pseudowasabi.orderservice.web.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pseudowasabi.orderservice.domain.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponse {
    private String orderId;
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;

    public OrdersResponse(Orders orders) {
        this.orderId = orders.getOrderId();
        this.productId = orders.getProductId();
        this.quantity = orders.getQuantity();
        this.unitPrice = orders.getUnitPrice();
        this.totalPrice = orders.getTotalPrice();
        this.createdDateTime = orders.getCreatedDateTime();
        this.modifiedDateTime = orders.getModifiedDateTime();
    }
}
