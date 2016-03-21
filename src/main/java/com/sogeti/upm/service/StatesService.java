package com.sogeti.upm.service;

import java.util.List;

import com.sogeti.upm.model.States;

public interface StatesService {
	
	public List<States> getStates();

	public void populateStates();

}
