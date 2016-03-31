package com.sogeti.petstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.petstore.dao.CartDAO;
import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	@Override
	public void createOrUpdateCart(Cart cart) {
		if(cart !=null && cart.getEmailId()!=null){
			Cart existingCart = cartDAO.getCart(cart.getEmailId());
			if(null!=existingCart){
				cartDAO.updateCart(cart);
			}else{
				cartDAO.saveCart(cart);
			}
		}
	}

	@Override
	public Cart getCart(String loginId) {
		return cartDAO.getCart(loginId);
	}

	@Override
	public void removeCartItem(CartDetail cartDetail) {
		cartDAO.removeCartItem(cartDetail);
	}

}
