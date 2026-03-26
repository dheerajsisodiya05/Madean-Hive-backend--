package com.madeanhive.repository;

import com.madeanhive.model.Cart;
import com.madeanhive.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.madeanhive.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);


}
