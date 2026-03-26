package com.madeanhive.service;

import com.madeanhive.exception.ProductException;
import com.madeanhive.model.Cart;
import com.madeanhive.model.CartItem;
import com.madeanhive.model.Product;
import com.madeanhive.model.User;

public interface CartService {
	
	public CartItem addCartItem(User user,
								Product product,
								String size,
								int quantity) throws ProductException;
	
	public Cart findUserCart(User user);

}
