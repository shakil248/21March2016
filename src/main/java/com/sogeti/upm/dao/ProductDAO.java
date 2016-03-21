package com.sogeti.upm.dao;

import java.util.List;

import com.sogeti.upm.model.Product;

public interface ProductDAO {
	
	public void createOrUpdateProduct(Product product);
	
	public Product getProduct(String productId);
	
	public List<Product> getProducts(String productCatId);

}
