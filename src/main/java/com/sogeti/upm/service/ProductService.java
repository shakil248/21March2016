package com.sogeti.upm.service;

import java.util.List;

import com.sogeti.upm.model.Product;

public interface ProductService {
	
	public void createOrUpdateProduct(Product product);
	public Product getProduct(String productId);
	public List<Product> getProducts(String productCatId);

}
