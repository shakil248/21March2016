package com.sogeti.upm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sogeti.upm.model.Product;

@Repository
public class ProductDAOImpl extends BaseDAO implements ProductDAO {

	

	

	@Override
	public List<Product> getProducts(String productCatId) {
		return null;
	}

	@Override
	public void createOrUpdateProduct(Product product) {
		saveOrUpdate(product);
		
	}

	@Override
	public Product getProduct(String productId) {
		return get(Product.class, productId);
	}

}
