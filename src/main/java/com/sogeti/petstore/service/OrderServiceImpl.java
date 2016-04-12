package com.sogeti.petstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.petstore.dao.OrderDAO;
import com.sogeti.petstore.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void createOrder(Order order) {
		orderDAO.createOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public Order getOrder(String emailId) {
		return orderDAO.getOrder(emailId);
	}

}
