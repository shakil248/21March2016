package com.sogeti.upm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.upm.dao.OrderDAO;
import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void createOrder(Cart cart) {
		orderDAO.createOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public Order getOrder(String loginId) {
		return orderDAO.getOrder(loginId);
	}

}
