package com.sogeti.petstore.service;

import com.sogeti.petstore.model.Order;

public interface OrderService {

	public void createOrder(Order order);
	public void updateOrder(Order order);
	public Order getOrder(String emailId);
}
