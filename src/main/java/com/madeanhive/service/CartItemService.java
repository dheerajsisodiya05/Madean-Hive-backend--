package com.madeanhive.service;

import com.madeanhive.exception.CartItemException;
import com.madeanhive.exception.UserException;
import com.madeanhive.model.CartItem;


public interface CartItemService {
	
	public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
