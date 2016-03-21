package com.sogeti.upm.dao;

import com.sogeti.upm.model.User;

public interface UserDAO {

	public void createOrUpdateUser(User user);
	public User getUser(String id);
	public User getUserByLoginId(String loginId);
	
}
