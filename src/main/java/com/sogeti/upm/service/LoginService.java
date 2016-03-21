package com.sogeti.upm.service;

import com.sogeti.upm.model.UserOTP;

public interface LoginService {
	
	public boolean doLogin(String loginId, String password, String otp);
	
	public UserOTP generateOTP(String loginId);

}
