package com.pseudowasabi.orderservice.domain.order;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
    Orders findByOrderId(String orderId);
    Iterable<Orders> findAllByUserId(String userId);
}
