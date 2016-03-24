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

import com.sogeti.upm.model.Cart;
import com.sogeti.upm.model.Order;
import com.sogeti.upm.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/getorder", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@RequestParam(value = "loginId") String loginId) {
		Order order =  orderService.getOrder(loginId);
	return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/createorder", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> createOrder(@RequestBody Cart cart) {
		 orderService.createOrder(cart);
	 return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/updateorder", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> updateOrder(@RequestBody Order order) {
		 orderService.updateOrder(order);
	 return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
