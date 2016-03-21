package com.sogeti.upm.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.upm.model.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void createOrUpdateUser(User user) {
		saveOrUpdate(user);
		
	}

	@Override
	public User getUser(String id) {
		return get(User.class, id);		
	}
	
	@Override
	public User getUserByLoginId(String loginId){
		Criteria cr = getSession().createCriteria(User.class);
		cr.add(Restrictions.eq("loginId", loginId));
		if(cr.list().size()>0){
			return (User) cr.list().get(0);
		}
		return null;
		
	}

}
