package com.sogeti.petstore.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;

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
