package com.sogeti.upm.service;

import java.util.List;

import com.sogeti.upm.model.Product;
import com.sogeti.upm.model.ProductCategory;

public interface ProductCatService {
	
	public void createOrUpdateProductCat(ProductCategory productCategory);
	public ProductCategory getProductCat(String productCatId);
	public List<ProductCategory> getProductCategories();

}
