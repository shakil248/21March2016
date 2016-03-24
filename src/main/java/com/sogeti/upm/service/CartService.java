package com.sogeti.upm.service;

import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.CartDetail;

public interface CartService {
	
	public void createOrUpdateCart(Cart cart);
	public Cart getCart(String loginId);
	public void removeCartItem(CartDetail cartDetail);

}
