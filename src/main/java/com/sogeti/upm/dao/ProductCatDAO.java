package com.sogeti.upm.dao;

import java.util.List;

import com.sogeti.upm.model.Product;
import com.sogeti.upm.model.ProductCategory;

public interface ProductCatDAO {
	
	public void createOrUpdateProductCat(ProductCategory productCategory);
	
	public ProductCategory getProductCat(String productCatId);
	
	public List<ProductCategory> getProductCategories();

}
