package com.sogeti.upm.service;

import com.sogeti.upm.model.User;

public interface UserService {
	
	public void createOrUpdateUser(User user);
	public User getUser(String id);
	public User getUserByLoginId(String loginId);

}
