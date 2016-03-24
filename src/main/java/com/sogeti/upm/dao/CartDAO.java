package com.sogeti.upm.dao;

import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.CartDetail;


public interface CartDAO {
	
	public void saveCart(Cart cart);
	public void updateCart(Cart cart);
	public Cart getCart(String loginId);
	public void removeCartItem(CartDetail cartDetail);
	

}
