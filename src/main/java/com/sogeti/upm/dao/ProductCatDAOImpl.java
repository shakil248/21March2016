package com.sogeti.upm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sogeti.upm.model.Product;
import com.sogeti.upm.model.ProductCategory;

@Repository
public class ProductCatDAOImpl extends BaseDAO implements ProductCatDAO {

	@Override
	public void createOrUpdateProductCat(ProductCategory productCategory) {
		saveOrUpdate(productCategory);
		
	}

	@Override
	public ProductCategory getProductCat(String productCatId) {
		return get(ProductCategory.class, productCatId);
	}

	@Override
	public List<ProductCategory> getProductCategories() {
		return getAll(ProductCategory.class);
	}

	

	

	

}
