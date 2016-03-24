package com.sogeti.upm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.upm.dao.CartDAO;
import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.CartDetail;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	@Override
	public void createOrUpdateCart(Cart cart) {
		if(cart !=null && cart.getLoginId()!=null){
			Cart existingCart = cartDAO.getCart(cart.getLoginId());
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
