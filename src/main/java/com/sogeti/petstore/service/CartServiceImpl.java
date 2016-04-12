package com.sogeti.petstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.petstore.dao.CartDAO;
import com.sogeti.petstore.dao.ProductDAO;
import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;
import com.sogeti.petstore.model.Product;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void createOrUpdateCart(Cart cart) {
		
		if(cart !=null && cart.getCartDetails()!=null && cart.getCartDetails().size()>0){
			CartDetail cartDetail = cart.getCartDetails().get(0);
			boolean inStock = checkStock(cartDetail);
			Cart existingCart = null;
			if(cart.getEmailId()!=null){
				 existingCart = cartDAO.getCart(cart.getEmailId());
			}
			
			if(inStock){
					if(null!=existingCart){
						existingCart.getCartDetails().add(cartDetail);
						cartDAO.updateCart(existingCart);
					}else{
						cartDAO.saveCart(cart);
					}
			}
		}
	}

	private boolean checkStock(CartDetail cartDetail) {
		Product product = productDAO.getProduct(cartDetail.getProductId());
		if(product.getInStock()>=cartDetail.getQuantity()){
			return true;
		}
		return false;
	}

	@Override
	public Cart getCart(String emailId) {
		return cartDAO.getCart(emailId);
	}

	@Override
	public void removeCartItem(CartDetail cartDetail) {
		cartDAO.removeCartItem(cartDetail);
	}

}
