package com.sogeti.upm.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.CartDetail;

@Repository
public class CartDAOImpl extends BaseDAO implements CartDAO {

	

	@Override
	public Cart getCart(String loginId) {
		Criteria cr = getSession().createCriteria(Cart.class);
		cr.add(Restrictions.eq("loginId", loginId));
		if(cr.list().size()>0){
			return (Cart) cr.list().get(0);
		}
		return null;
	}

	@Override
	public void saveCart(Cart cart) {
		persist(cart);
		
	}

	@Override
	public void updateCart(Cart cart) {
		update(cart);
		
	}

	@Override
	public void removeCartItem(CartDetail cartDetail) {
		delete(cartDetail);
		
	}

}
