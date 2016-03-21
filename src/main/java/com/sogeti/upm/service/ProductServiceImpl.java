package com.sogeti.upm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.upm.dao.ProductDAO;
import com.sogeti.upm.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO; 
	
	
	

	@Override
	public List<Product> getProducts(String productCatId) {
		return productDAO.getProducts(productCatId);
	}




	@Override
	public void createOrUpdateProduct(Product product) {
		productDAO.createOrUpdateProduct(product);
		
	}




	@Override
	public Product getProduct(String productId) {
		return productDAO.getProduct(productId);
	}

}
