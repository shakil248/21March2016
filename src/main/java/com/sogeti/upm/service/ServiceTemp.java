package com.sogeti.upm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.upm.dao.BaseDAO;


@Service
@Transactional
public class ServiceTemp {
	
	@Autowired
	private BaseDAO baseDAO;
	
	public <T> void persist(T entity){
		baseDAO.persist(entity);
	}
	
	public <T> void update(T entity){
		baseDAO.update(entity);
	}
	
	public <T,V extends String> T get(Class<T> type, V id){
		return baseDAO.get(type, id);
	}

}
