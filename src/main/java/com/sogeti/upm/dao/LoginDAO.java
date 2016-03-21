package com.sogeti.upm.dao;

import com.sogeti.upm.model.UserOTP;

public interface LoginDAO {
	
	public UserOTP getUserOTP(String id);
	
	public void createUserOTP(UserOTP userOTP);
	
	public void updateUserOTP(UserOTP userOTP);

	public UserOTP getUserOTPByLoginId(String loginId);

	public void deleteUserOTP(UserOTP userOTP);
	

}
