package com.sogeti.upm.dao;

import java.util.List;

import com.sogeti.upm.model.States;

public interface StatesDAO {
	public List<States> getStates();
	
	public void createStates(States states);
}
