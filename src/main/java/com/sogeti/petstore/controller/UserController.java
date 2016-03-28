package com.sogeti.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sogeti.petstore.model.States;
import com.sogeti.petstore.model.User;
import com.sogeti.petstore.service.StatesService;
import com.sogeti.petstore.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StatesService statesService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	   public String  printHello() {
		statesService.populateStates();	     
		return "index";
	   }
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	    public ResponseEntity<User> getUser(@RequestParam(value = "loginId") String loginId) {
		  User user =  userService.getUserByLoginId(loginId);
		  if(null!=user){
//			  String s = new String(user.getImage());
//			  user.setData(s);
		  }
		  return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/states", method = RequestMethod.GET)
	    public ResponseEntity<List<States>> getStates() {
	        List<States> states = statesService.getStates();
	        return new ResponseEntity<List<States>>(states, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> createUser(@RequestBody User user) {
//			user.setImage(user.getData().getBytes());
		 	user.setData(null);
	        userService.createOrUpdateUser(user);
	        return new ResponseEntity<Void>(HttpStatus.CREATED);
	    }
	 
	 @RequestMapping(value = "/dologin", method = RequestMethod.GET)
	    public boolean dologin(@RequestParam String loginId, String password, String otp) {
		  return userService.doLogin(loginId, password, otp);
	    }
}
