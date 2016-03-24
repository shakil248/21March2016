package com.sogeti.upm.service;

import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.Order;

public interface OrderService {

	public void createOrder(Cart cart);
	public void updateOrder(Order order);
	public Order getOrder(String loginId);
}
