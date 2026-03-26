package com.madeanhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madeanhive.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	 Cart findByUserId(Long userId);
}
