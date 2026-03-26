package com.madeanhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madeanhive.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
