package com.sogeti.upm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sogeti.upm.model.Product;
import com.sogeti.upm.model.User;
import com.sogeti.upm.service.ProductService;
import com.sogeti.upm.service.StatesService;
import com.sogeti.upm.service.UserService;

@Controller
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	
	
	@RequestMapping(value = "/getproduct", method = RequestMethod.GET)
	    public ResponseEntity<Product> getProduct(@RequestParam(value = "productId") String productId) {
		Product product = productService.getProduct(productId);
		  if(null!=product){
			  String s = new String(product.getImage());
			  product.setData(s);
		  }
		  return new ResponseEntity<Product>(product, HttpStatus.OK);
	    }
	
	@RequestMapping(value = "/createproduct", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Void> createProduct(@RequestBody Product product) {
		product.setImage(product.getData().getBytes());
		product.setData(null);
        productService.createOrUpdateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
