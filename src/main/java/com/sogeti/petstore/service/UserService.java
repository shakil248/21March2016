package com.sogeti.petstore.service;

import com.sogeti.petstore.model.User;

public interface UserService {
	
	public void createOrUpdateUser(User user);
	public User getUser(String id);
	public User getUserByLoginId(String loginId);
	public boolean doLogin(String loginId, String password, String otp);

}
