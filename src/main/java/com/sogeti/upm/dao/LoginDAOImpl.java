package com.sogeti.upm.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.upm.model.UserOTP;

@Repository
public class LoginDAOImpl  extends BaseDAO implements LoginDAO{

	@Override
	public UserOTP getUserOTP(String id) {
		return get(UserOTP.class, id);		
	}

	@Override
	public void createUserOTP(UserOTP userOTP) {
		persist(userOTP);
	}

	@Override
	public void deleteUserOTP(UserOTP userOTP) {
		delete(userOTP);
	}

	@Override
	public void updateUserOTP(UserOTP userOTP) {
		update(userOTP);
	}
	
	@Override
	public UserOTP getUserOTPByLoginId(String loginId) {
		Criteria cr = getSession().createCriteria(UserOTP.class);
		cr.add(Restrictions.eq("loginId", loginId));
		if(cr.list().size()>0){
			return (UserOTP) cr.list().get(0);
		}
		return null;
	}

}
