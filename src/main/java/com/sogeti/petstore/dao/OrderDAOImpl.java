package com.sogeti.petstore.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.Order;
import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.spring.AppConfig;

@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

	@Override
	public void createOrder(Order order) {
		persist(order);

	}

	@Override
	public void updateOrder(Order order) {
		update(order);

	}

	@Override
	public Order getOrder(String loginId) {
		Criteria cr = getSession().createCriteria(Order.class);
		cr.add(Restrictions.eq("loginId", loginId));
		if(cr.list().size()>0){
			return (Order) cr.list().get(0);
		}
		return null;
	}
	


}
