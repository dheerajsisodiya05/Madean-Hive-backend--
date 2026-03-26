package com.madeanhive.service;

import com.madeanhive.domain.OrderStatus;
import com.madeanhive.exception.OrderException;
import com.madeanhive.model.Address;
import com.madeanhive.model.Cart;
import com.madeanhive.model.User;
import com.madeanhive.model.*;
import com.madeanhive.model.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {
	
	public Set<Order> createOrder(User user, Address shippingAddress, Cart cart);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public List<Order>getShopsOrders(Long sellerId);

	public Order updateOrderStatus(Long orderId,
								   OrderStatus orderStatus)
			throws OrderException;
	
	public void deleteOrder(Long orderId) throws OrderException;

	Order cancelOrder(Long orderId,User user) throws OrderException;
	
}
