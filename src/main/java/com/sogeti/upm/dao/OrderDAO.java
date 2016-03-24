package com.sogeti.upm.dao;

import com.sogeti.upm.model.Order;

public interface OrderDAO {
	
	public void createOrder(Order order);
	public void updateOrder(Order order);
	public Order getOrder(String loginId);

}
