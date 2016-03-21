package com.sogeti.upm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.upm.model.UserOTP;
import com.sogeti.upm.service.LoginService;

@RestController
public class LoginController {
	
	
	@Autowired
	LoginService loginService ;
	
		 
	 	@RequestMapping(value = "/generateotp", method = RequestMethod.GET)
	    public ResponseEntity<UserOTP> generateotp(@RequestParam(value = "loginId") String loginId) {
	 		UserOTP otp = loginService.generateOTP(loginId);
	 		return new ResponseEntity<UserOTP>(otp, HttpStatus.OK);
	    }
	 	
	 	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	    public boolean dologin(@RequestParam String loginId, String password, String otp) {
		  return loginService.doLogin(loginId, password, otp);
	    }

}
