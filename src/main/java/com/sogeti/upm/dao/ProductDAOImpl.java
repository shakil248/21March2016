package com.sogeti.upm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.upm.model.Product;
import com.sogeti.upm.model.User;

@Repository
public class ProductDAOImpl extends BaseDAO implements ProductDAO {

	

	

	@Override
	public List<Product> getProducts(String productCatId) {
		
			Criteria cr = getSession().createCriteria(Product.class);
			cr.add(Restrictions.eq("productCatId", productCatId));
			if(cr.list().size()>0){
				return (List<Product>) cr.list();
			}
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
